package com.money.lava.deal.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.money.lava.deal.R;

public class RegisterAsLenderFragment extends Fragment {

    public RegisterAsLenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_as_lender, container, false);
        getActivity().setTitle("Register As Lender");
        findWidgets(view);

        return view;
    }

    private void findWidgets(View view) {
        LinearLayout llRegister = (LinearLayout) view.findViewById(R.id.ll_register);
        llRegister.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new LendFragment())
                    .commit();
        });
    }

}
