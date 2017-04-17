package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

/**
 * Created by dainguyen on 4/17/17.
 */

public class Review implements IData {
    private int id ;
    private int id_cus;
    private int id_store;
    private int rate;
    private String content;

    public Review(int id, int id_cus, int id_store, int rate, String content) {
        this.id = id;
        this.id_cus = id_cus;
        this.id_store = id_store;
        this.rate = rate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cus() {
        return id_cus;
    }

    public void setId_cus(int id_cus) {
        this.id_cus = id_cus;
    }

    public int getId_store() {
        return id_store;
    }

    public void setId_store(int id_store) {
        this.id_store = id_store;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
