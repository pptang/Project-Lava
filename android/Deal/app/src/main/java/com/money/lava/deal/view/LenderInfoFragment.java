package com.money.lava.deal.view;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.money.lava.deal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LenderInfoFragment extends DialogFragment {


    public LenderInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lender_info, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {

    }

}
