package com.example.dainguyen.fcoffee.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by NguyenVanDai on 2/2/2017.
 */

public abstract class MyDatabaseHelper extends SQLiteOpenHelper {
    public static  final  int VERSION =1 ;
    public static String PATH ="data/data/com.example.dainguyen.fcoffee/databases/";
    public static String PATHNAME ="Dictionary.db";


    public SQLiteDatabase mdatabase;
    private static Context context;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, PATHNAME, factory, version);
        this.context = context;
    }

    @Override
    public synchronized void close() {
        if(mdatabase!=null && mdatabase.isOpen()) mdatabase.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void onOpenDatabase() {
        String path2 = context.getDatabasePath(PATHNAME).getPath();
        if(mdatabase !=null && mdatabase.isOpen()){
            return;
        }
        else {
            mdatabase = SQLiteDatabase.openDatabase(path2,null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

        public abstract ArrayList<IData> SearchData(String... args );

        public abstract boolean RemoveData(String... args);

        public abstract boolean InsertData(String... args);

        public abstract boolean Update(String... args);

}
