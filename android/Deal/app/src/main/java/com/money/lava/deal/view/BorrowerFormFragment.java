package com.money.lava.deal.view;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.money.lava.deal.R;
import com.money.lava.deal.alert.Alert;

import org.w3c.dom.Text;

public class BorrowerFormFragment extends DialogFragment implements View.OnTouchListener {


    public BorrowerFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_form, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {
        RelativeLayout rlContainer = (RelativeLayout) v.findViewById(R.id.rl_container);
        rlContainer.setOnTouchListener(this);

        LinearLayout llConfirm = (LinearLayout) v.findViewById(R.id.llConfirm);
        llConfirm.setOnClickListener(view -> {
            dismiss();
            Alert.show(getActivity(), "Successfully Sent！Please wait for response！");

        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromInputMethod(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return false;
    }
}
