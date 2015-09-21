package com.money.lava.deal.alert;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by Bible on 9/16/15.
 */
public class Alert {

    public static void show(Context context, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.show();
    }
}
