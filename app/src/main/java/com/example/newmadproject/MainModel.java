package com.example.newmadproject;

public class MainModel {

    String orderid;
    String customername;
    String email;
    String number;
    String address;
    String zipcode;
    String date;
    String items;
    String price;
    String time;
    String deliverystatus;

    MainModel(){

    }

    public MainModel(String orderid, String customername, String email, String number, String address, String zipcode, String date, String items, String price, String time, String deliverystatus) {
        this.orderid = orderid;
        this.customername = customername;
        this.email = email;
        this.number = number;
        this.address = address;
        this.zipcode = zipcode;
        this.date = date;
        this.items = items;
        this.price = price;
        this.time = time;
        this.deliverystatus = deliverystatus;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
