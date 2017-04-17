package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class FavoritStore implements IData {
    private int id_store;
    private ArrayList<Integer>arrCustomer;

    public FavoritStore(int id_store, ArrayList<Integer> arrCustomer) {
        this.id_store = id_store;
        this.arrCustomer = arrCustomer;
    }

    public ArrayList<Integer> getArrCustomer() {
        return arrCustomer;
    }

    public void setArrCustomer(ArrayList<Integer> arrCustomer) {
        this.arrCustomer = arrCustomer;
    }

    public int getId_store() {
        return id_store;
    }

    public void setId_store(int id_store) {
        this.id_store = id_store;
    }
}
