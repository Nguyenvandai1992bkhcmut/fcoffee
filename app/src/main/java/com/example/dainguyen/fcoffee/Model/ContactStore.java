package com.example.dainguyen.fcoffee.Model;

import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class ContactStore implements IData {

        private int id_store;
        private ArrayList<String>phones;

        public ContactStore(int id_store, ArrayList<String> phones) {
            this.id_store = id_store;
            this.phones = phones;
        }

        public int getId_store() {
            return id_store;
        }

        public void setId_store(int id_store) {
            this.id_store = id_store;
        }

        public ArrayList<String> getPhones() {
            return phones;
        }

        public void setPhones(ArrayList<String> phones) {
            this.phones = phones;
        }

}
