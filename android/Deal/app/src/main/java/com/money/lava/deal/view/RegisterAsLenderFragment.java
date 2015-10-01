package com.money.lava.deal.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.money.lava.deal.R;

public class RegisterAsLenderFragment extends Fragment {

    public RegisterAsLenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_as_lender, container, false);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View view) {

    }

}
