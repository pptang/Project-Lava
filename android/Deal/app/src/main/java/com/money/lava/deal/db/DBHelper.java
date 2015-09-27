package com.money.lava.deal.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "lavaDB.db";
    public static SQLiteDatabase myDB;
    public static final int VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name){
        this(context, name, null, VERSION);
    }

    public DBHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (myDB == null || !myDB.isOpen()) {
            myDB = new DBHelper(context, DATABASE_NAME, null, VERSION)
                    .getWritableDatabase();
        }

        return myDB;
    }



    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(LendTable.CREATE_LEND_TABLE);
        db.execSQL(BorrowTable.CREATE_BORROW_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
