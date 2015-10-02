package com.money.lava.deal.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.money.lava.deal.R;

public class RegisterAsBorrowerFragment extends Fragment {


    public RegisterAsBorrowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Register As Borrower");
        View view = inflater.inflate(R.layout.fragment_register_as_borrower, container, false);
        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {
        LinearLayout llRegister = (LinearLayout) v.findViewById(R.id.ll_register);
        llRegister.setOnClickListener(view -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new BorrowFragment()).commit();
        });
    }


}
