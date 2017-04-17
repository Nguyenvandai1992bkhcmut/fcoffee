package com.example.dainguyen.fcoffee.DatabaseManager;

import android.content.ClipboardManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.provider.Contacts;

import com.example.dainguyen.fcoffee.Constant.ConstantDictionary;
import com.example.dainguyen.fcoffee.Model.ContactStore;
import com.example.dainguyen.fcoffee.Model.Customer;
import com.example.dainguyen.fcoffee.Model.Favorit;
import com.example.dainguyen.fcoffee.Model.FavoritCustomer;
import com.example.dainguyen.fcoffee.Model.FavoritStore;
import com.example.dainguyen.fcoffee.Model.Review;
import com.example.dainguyen.fcoffee.Model.ReviewStore;
import com.example.dainguyen.fcoffee.Model.Store;
import com.example.dainguyen.fcoffee.Model.ViewStore;

import java.util.ArrayList;

/**
 * Created by dainguyen on 4/17/17.
 */

public class Dictionary extends MyDatabaseHelper {
    public Dictionary(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public ArrayList<IData> SearchData(String... args) {
        ArrayList<IData>result = new ArrayList<>();
        String sql="";
        Cursor cursor = null;
        switch (args[0]){
            /*
                Contact
             */
            case ConstantDictionary.TABLE_CONTACT:
                if(args.length==1){

                    /*
                    select all phone of stores
                    result := arraylist<Model.ContactStore>
                     */
                    sql = "Select * from ContactStore";
                }
                else if (args.length ==3 && args[1].equals(ConstantDictionary.SELECT_1_CONTACTSTORE)){

                      /*
                    select all phone of  1 store with id_store
                    result := arraylist<Model.ContactStore>
                     */

                    sql = "Select * from ContactStore  where id_store = "+ Integer.valueOf(args[2]);
                }
                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    int flag =0;
                    int id_store = cursor.getInt(0);
                    String phone = cursor.getString(1);
                    for(int i=0;i<result.size();i++){
                        ContactStore contactStore = (ContactStore) result.get(i);
                        if(contactStore.getId_store()== id_store){
                            flag=1;
                            contactStore.getPhones().add(phone);
                            break;
                        }
                    }
                    if(flag==0) {
                        ArrayList<String>phones = new ArrayList<>();
                        phones.add(phone);
                        result.add(new ContactStore(cursor.getInt(0),phones));
                    }
                    cursor.moveToNext();
                }
                break;

            /*
            Customer
             */

            case ConstantDictionary.TABLE_CUSTOMER:

                if(args.length == 1){

                    /*
                    Select all Customer
                    result := Arraylist<Model.Customer>
                     */

                    sql = "Select * from Customer";

                }else if (args.length == 3 && args[1].equals(ConstantDictionary.SELECT_1_CUSTOMER)){

                      /*
                    Select 1 Customer with id = (int)arrg[1]
                    result := Arraylist<Model.Customer>
                     */
                    sql = "Select * from Customer where id = " + Integer.valueOf(args[2]);

                }
                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    result.add(new Customer(cursor.getInt(0), cursor.getString(1) , cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5)));
                    cursor.moveToNext();
                }
                break;

            /*
            Favorit
             */
            case ConstantDictionary.TABLE_FAVORIT:
                int t =0;
                if(args.length==1){

                    /*
                    Select all table Favorit
                    Result := Arraylist<Model.Favorit>
                     */
                    sql = "select * from Favorit";
                }else if(args.length ==3 && args[1].equals(ConstantDictionary.SELECT_FAVORIT_CUSTOMER)){

                    /*
                    Select all store which customer like
                    Result := Arraylist<Model.FavoritCustomer>
                     */
                    sql = "select * from Favorit where id_customer = "+Integer.valueOf(args[2]);
                    t=1;
                }else if(args.length ==3 && args[1].equals(ConstantDictionary.SELECT_FAVORIT_STORE)){

                    /*
                    Select all customer who  like store
                    Result := Arraylist<Model.FavoritStore>
                     */
                    sql = "select * from Favorit where id_store = "+Integer.valueOf(args[2]);
                    t=2;
                }
                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                if(t==0){
                    while (!cursor.isAfterLast()){

                        result.add(new Favorit(cursor.getInt(0), cursor.getInt(1)));
                    }
                }else if(t==1){

                    while (!cursor.isAfterLast()){
                        int idCus = cursor.getInt(0);
                        int idSto = cursor.getInt(1);
                        if(result.size()==0){
                            ArrayList<Integer>arrStore = new ArrayList<>();
                            arrStore.add(idSto);
                            result.add(new FavoritCustomer(idCus,arrStore));
                        }else{
                            FavoritCustomer favoritCustomer = (FavoritCustomer) result.get(0);
                            favoritCustomer.getStores().add(idSto);
                        }
                        cursor.moveToNext();
                    }
                }else if(t==2){

                    while (!cursor.isAfterLast()){
                        int idCus = cursor.getInt(0);
                        int idSto = cursor.getInt(1);
                        if(result.size()==0){
                            ArrayList<Integer>arrCus = new ArrayList<>();
                            arrCus.add(idCus);
                            result.add(new FavoritCustomer(idSto,arrCus));
                        }else{
                            FavoritStore favoritStore = (FavoritStore) result.get(0);
                            favoritStore.getArrCustomer().add(idCus);
                        }
                        cursor.moveToNext();
                    }
                }
                break;

            /*
            Review
             */
            case ConstantDictionary.TABLE_REVIEW:
                int type =0;
                if(args.length==1){
                    /*
                    Select all tableReview
                    Result:=ArrayList<Model.Review>
                     */

                    sql = "Select * from Review";

                }else if(args.length==3 && args[1].equals(ConstantDictionary.SELECT_REVIEW_STORE)){
                    /*
                    Select all Review for 1 store
                    Result:Arraylist<Model.ReviewStore>
                     */

                    sql = "Select * from Review where id_store =" + Integer.valueOf(args[2]);
                    type=1;
                }

                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                if(type==0){
                    while (!cursor.isAfterLast()){
                        result.add(new Review(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4)));
                        cursor.moveToNext();
                    }
                }else if (type ==1){

                    while (!cursor.isAfterLast()){
                        if(result.size()==0){
                            ArrayList<Integer>idcus =new ArrayList<>();
                            ArrayList<Integer>rates = new ArrayList<>();
                            ArrayList<String>contents = new ArrayList<>();
                            idcus.add(cursor.getInt(1));
                            rates.add(cursor.getInt(3));
                            contents.add(cursor.getString(4));
                            result.add(new ReviewStore(cursor.getInt(2),idcus,rates,contents));
                        }else{
                            ReviewStore reviewStore = (ReviewStore) result.get(0);
                            reviewStore.getContent().add(cursor.getString(4));
                            reviewStore.getIdcus().add(cursor.getInt(1));
                            reviewStore.getRate().add(cursor.getInt(3));
                        }
                        cursor.moveToNext();
                    }
                }

                break;

            /*
            Table store
             */
            case ConstantDictionary.TABLE_STORE:
                if(args.length==1){
                    /*
                    Select all infomation store
                     */

                    sql ="Select * from store";
                }else if(args.length ==3 && args[1].equals(ConstantDictionary.SELECT_1_STORE)){

                    /*
                    SELECT 1 INFORMATION STORE
                    resutl:Arraylist<Model.Store>     note: only 1 element
                     */

                    sql = "Select * from store where id = " + Integer.valueOf(args[2]);
                }
                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    result.add(new Store(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getString(5), cursor.getInt(6)));
                    cursor.moveToNext();
                }
                break;

            /*
            Table View Store
             */
            case ConstantDictionary.TABLE_VIEWSTORE:
                if(args.length==1){
                    /*
                    Select all view Store
                     */
                    sql = "Select * from ViewStore";
                }
                else if(args.length==3 && args[1].equals(ConstantDictionary.SELECT_1_VIEWSTORE)){
                    /*
                    Select 1 viewstore
                     */
                    sql ="Select* from ViewStore where id_store = " + Integer.valueOf(args[2]);
                }
                onOpenDatabase();
                try {
                    cursor = mdatabase.rawQuery(sql, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    int flag =0;
                    for (int i =0;i<result.size();i++){
                        ViewStore viewStore = (ViewStore) result.get(i);
                        if(viewStore.getIdstore()== cursor.getInt(0)){
                            flag=1;
                            viewStore.getSrcImage().add(cursor.getString(1));
                        }
                    }
                    if(flag==0){
                        ArrayList<String>arrVS = new ArrayList<>();
                        arrVS.add(cursor.getString(1));
                        result.add(new ViewStore(cursor.getInt(0),arrVS));
                    }
                    cursor.moveToNext();
                }
                break;

            default:


        }
        return result;
    }

    @Override
    public boolean RemoveData(String... args) {
        String sql ="";
        switch (args[0]){
            case ConstantDictionary.REMOVE_ID_CUSTOMER:
                if(args.length ==2){
                    sql ="delete from customer where id = ?";
                }
                break;
            case ConstantDictionary.REMOVE_ID_REVIEW:
                if(args.length==2){
                    sql = "delete from Review where id = ?" ;
                }
                break;
            case ConstantDictionary.REMOVE_ID_STORE:
                if(args.length==2){
                    sql = "delete from STORE where id = ?" ;
                }
                break;
            case ConstantDictionary.REMOVE_ID_VIEWSTORE:
                if(args.length==2){
                    sql = "delete from ViewStore where id_store = ?";
                }
                break;
            case ConstantDictionary.REMOVEW_ID_CONTACTSTORE:
                if(args.length==2){
                    sql = "delete from COntactStore where id_store = ?";
                }
                break;

        }
        onOpenDatabase();
        try {

            SQLiteStatement statement = mdatabase.compileStatement(sql);
            statement.bindLong(1,Integer.valueOf(args[1]));
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean InsertData(String... args) {
        return false;
    }

    @Override
    public boolean Update(String... args) {
        return false;
    }
}
