package com.money.lava.deal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.money.lava.deal.model.LendItem;

import java.util.ArrayList;
import java.util.List;


public class LendTable extends BaseTable {

    public static final String TABLE_NAME = "lendTable";
//    public static final String LENDER_ID = "lendId";
    public static final String LENDER_NAME = "lendName";
    public static final String AMOUNT = "amount";
    public static final String INTEREST_RATE = "interestRate";
//    public static final String PROFESSION = "profession";
//    public static final String INCOME = "income";
//    public static final String INVESTMENT = "investment";
//    public static final String SOURCE = "source";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public static final String CREATE_LEND_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + " (" + _ID + " INTEGER PRIMARY KEY," + LENDER_NAME + TEXT_TYPE + COMMA_SEP
            + AMOUNT + TEXT_TYPE + COMMA_SEP + INTEREST_RATE + TEXT_TYPE + ")";

    public LendTable(Context context) {
        super(context);
    }

    public void insert(LendItem item) {
        ContentValues cv = new ContentValues();

        cv.put(LENDER_NAME, item.getName());
        cv.put(AMOUNT, item.getAmount());
        cv.put(INTEREST_RATE, item.getRate());

        long id = db.insert(TABLE_NAME, null, cv);
    }

    public List<LendItem> getAll() {
        List<LendItem> result = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        cursor.close();
        return result;
    }

    private LendItem getRecord(Cursor cursor) {
        LendItem result = new LendItem(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return result;
    }


}
