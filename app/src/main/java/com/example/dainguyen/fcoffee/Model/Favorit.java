package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

/**
 * Created by dainguyen on 4/17/17.
 */

public class Favorit implements IData {
    private int id_customer ;
    private int id_store;

    public Favorit(int id_customer, int id_store) {
        this.id_customer = id_customer;
        this.id_store = id_store;
    }
}
