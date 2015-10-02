package com.money.lava.deal.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.money.lava.deal.R;
import com.money.lava.deal.adapter.LendAdapter;
import com.money.lava.deal.db.LendTable;
import com.money.lava.deal.logger.Dump;
import com.money.lava.deal.model.LendItem;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;


public class LendFragment extends Fragment implements View.OnTouchListener {

    LinearLayout llSend;
    EditText etName;
    EditText etAmount;
    EditText etRate;
    Context context;
    public LendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lend, container, false);

        context = getActivity();
        getActivity().setTitle("Lend");
        findWidgets(view);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    private void findWidgets(View view) {
        RelativeLayout rlLend = (RelativeLayout) view.findViewById(R.id.rl_lend);
        rlLend.setOnTouchListener(this);
        etAmount = (EditText) view.findViewById(R.id.etAmount);
        etName = (EditText) view.findViewById(R.id.etName);
        etRate = (EditText) view.findViewById(R.id.etRate);
        llSend = (LinearLayout) view.findViewById(R.id.ll_send);
        llSend.setOnClickListener(v -> {
            insertIntoLendTable(etName.getText().toString(), etAmount.getText().toString(),
                    etRate.getText().toString());
        });
    }

    private void insertIntoLendTable(String name, String amount, String rate) {

        new AsyncTask<Void, Void, LendItem>() {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(context);
                dialog.setMessage("Loading...");
                dialog.show();
            }

            @Override
            protected LendItem doInBackground(Void... params) {

                LendTable lendTable = new LendTable(context);
                LendItem item = new LendItem(name, amount, rate);
                lendTable.insert(item);

                return item;
            }

            @Override
            protected void onPostExecute(LendItem item) {
                super.onPostExecute(item);

                EventBus.getDefault().post(item);

                dialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Success!");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, new BorrowFragment())
                            .commit();
                });
                builder.show();

            }
        }.execute();
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return false;
    }
}
