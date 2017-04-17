package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class FavoritCustomer implements IData {
    private int id_customer;
    private ArrayList<Integer>stores;

    public FavoritCustomer(int id_customer, ArrayList<Integer> stores) {
        this.id_customer = id_customer;
        this.stores = stores;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public ArrayList<Integer> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Integer> stores) {
        this.stores = stores;
    }
}
