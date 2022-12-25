package com.example.newmadproject;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull MainModel model) {

        holder.orderid.setText(model.getOrderid());
        holder.items.setText(model.getItems());
        holder.date.setText(model.getDate());
        holder.total.setText(model.getPrice());
        holder.deliverystatus.setText(model.getDeliverystatus());

        holder.btnscroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.email.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_editorderdetailspage))
                        .setExpanded(true, 2100)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                TextView orderid = view.findViewById(R.id.updateid);
                TextView name = view.findViewById(R.id.updatecustomername);
                EditText email = view.findViewById(R.id.updateemail);
                EditText number = view.findViewById(R.id.updatenum);
                EditText address = view.findViewById(R.id.updateadrs);
                EditText zip = view.findViewById(R.id.updatezip);
                TextView date = view.findViewById(R.id.updatedate);
                TextView items = view.findViewById(R.id.updateitems);
                TextView totalprice = view.findViewById(R.id.updatetotal);
                TextView time = view.findViewById(R.id.updatetime);
                TextView deliverystatus = view.findViewById(R.id.updatedeliverystatus);


                Button btnupdate = view.findViewById(R.id.btnupdate);
                Button btndelete = view.findViewById(R.id.btndelete);

                orderid.setText(model.getOrderid());
                name.setText(model.getCustomername());
                email.setText(model.getEmail());
                number.setText(model.getNumber());
                address.setText(model.getAddress());
                zip.setText(model.getZipcode());
                date.setText(model.getDate());
                items.setText(model.getItems());
                totalprice.setText(model.getPrice());
                time.setText(model.getTime());
                deliverystatus.setText(model.getDeliverystatus());

                dialogPlus.show();

                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map1 = new HashMap<>();
                        map1.put("email",email.getText().toString());
                        map1.put("zipcode",zip.getText().toString());
                        map1.put("address",address.getText().toString());
                        map1.put("number",number.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Order")
                                .child(getRef(position).getKey()).updateChildren(map1)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.email.getContext(), "order updated successfully", Toast.LENGTH_LONG).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.email.getContext(), "Error while updating", Toast.LENGTH_LONG).show();

                                    }
                                });



                    }
                });

                btndelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(holder.email.getContext());
                        builder.setTitle("Are you sure?");
                        builder.setMessage("You cannot undo once you cancel an order.");

                        builder.setPositiveButton("cancel order", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                FirebaseDatabase.getInstance().getReference().child("Order")
                                        .child(Objects.requireNonNull(getRef(position).getKey())).removeValue();
                                Toast.makeText(holder.email.getContext(),"order cancelled successfully", Toast.LENGTH_SHORT).show();


                            }


                        });

                        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.show();
                    }
                });

            }
        });


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView email, zipcode, orderid, items, total, deliverystatus, date;
        Button btnscroll;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            email = (TextView) itemView.findViewById(R.id.emailtext);
            zipcode = (TextView) itemView.findViewById(R.id.ziptext);
            orderid = (TextView) itemView.findViewById(R.id.ordertext);
            items = (TextView) itemView.findViewById(R.id.itemstext);
            total = (TextView) itemView.findViewById(R.id.totaltext);
            deliverystatus = (TextView) itemView.findViewById(R.id.deliverystatustext);
            date = (TextView) itemView.findViewById(R.id.datetext);

            btnscroll = (Button) itemView.findViewById(R.id.btnscroll);

        }
    }

}
