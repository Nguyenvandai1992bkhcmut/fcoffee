package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.io.Serializable;

/**
 * Created by dainguyen on 4/17/17.
 */

public class Customer implements IData,Serializable {
    private int id ;
    private String usename ;
    private String password;
    private String mail;
    private String phone ;
    private int type;

    public Customer(int id, String usename, String password, String mail, String phone, int type) {
        this.id = id;
        this.usename = usename;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }
}
