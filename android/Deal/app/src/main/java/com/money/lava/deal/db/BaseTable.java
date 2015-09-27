package com.money.lava.deal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public abstract class BaseTable implements BaseColumns {

    protected SQLiteDatabase db;

    public BaseTable(Context context) {
        db = DBHelper.getDatabase(context);
    }

    private void close() {
        db.close();
    }
}
