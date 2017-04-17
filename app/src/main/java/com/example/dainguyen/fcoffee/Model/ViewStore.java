package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class ViewStore implements IData,Serializable {
    private int idstore ;
    private ArrayList<String>srcImage;

    public ViewStore(int idstore, ArrayList<String> srcImage) {
        this.idstore = idstore;
        this.srcImage = srcImage;
    }

    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    public ArrayList<String> getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(ArrayList<String> srcImage) {
        this.srcImage = srcImage;
    }
}
