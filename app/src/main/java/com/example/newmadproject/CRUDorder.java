package com.example.newmadproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CRUDorder {

    private DatabaseReference databaseReference;

    public CRUDorder(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Order.class.getSimpleName());

    }

    public Task<Void> add(Order order){

        return databaseReference.push().setValue(order);

    }




}
