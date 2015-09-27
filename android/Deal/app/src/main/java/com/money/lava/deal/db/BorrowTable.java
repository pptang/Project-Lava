package com.money.lava.deal.db;

import android.content.Context;

public class BorrowTable extends BaseTable {

    public static final String TABLE_NAME = "borrowTable";
    public static final String BORROWER_ID = "borrowerId";
    public static final String BORROWER_NAME = "borrowerName";
    public static final String PERIOD = "period";
    public static final String METHOD = "method";
    public static final String PURPOSE = "purpose";
    public static final String GUARANTEE = "guarantee";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public static final String CREATE_BORROW_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + " (" + _ID + " INTEGER PRIMARY KEY," + BORROWER_NAME + TEXT_TYPE + COMMA_SEP
            + BORROWER_ID + TEXT_TYPE + COMMA_SEP + PERIOD + TEXT_TYPE + COMMA_SEP + METHOD
            + TEXT_TYPE + COMMA_SEP + PURPOSE + TEXT_TYPE + COMMA_SEP + GUARANTEE + TEXT_TYPE + ")";

    public BorrowTable(Context context) {
        super(context);
    }

}
