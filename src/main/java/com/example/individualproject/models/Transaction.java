package com.example.individualproject.models;

import com.example.individualproject.models.enums.Status;

public class Transaction {
    public Transaction(int user_id, int item_id, Status status) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.status = status;
    }

    private int user_id;
    private int item_id;
    private Status status;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
