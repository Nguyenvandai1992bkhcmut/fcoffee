package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class ReviewStore implements IData {
    private int idstore;
    private ArrayList<Integer>idcus;
    private ArrayList<Integer>rate;
    private ArrayList<String>content;

    public ReviewStore(int idstore,ArrayList<Integer> idcus, ArrayList<Integer> rate, ArrayList<String> content) {
        this.idstore = idstore;
        this.idcus = idcus;
        this.rate = rate;
        this.content = content;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public ArrayList<Integer> getRate() {
        return rate;
    }

    public void setRate(ArrayList<Integer> rate) {
        this.rate = rate;
    }

    public ArrayList<Integer> getIdcus() {
        return idcus;
    }

    public void setIdcus(ArrayList<Integer> idcus) {
        this.idcus = idcus;
    }

    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }
}
