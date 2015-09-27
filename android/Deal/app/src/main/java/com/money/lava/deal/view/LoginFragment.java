package com.money.lava.deal.view;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.money.lava.deal.R;
import com.money.lava.deal.alert.Alert;
import com.money.lava.deal.application.CitiApplication;
import com.money.lava.deal.config.Config;
import com.money.lava.deal.logger.Dump;
import com.money.lava.deal.model.Login.Auth;
import com.money.lava.deal.model.Login.User;
import com.money.lava.deal.model.account.UserAccount;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginFragment extends Fragment {

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View view) {
        Button btnLogin = (Button) view.findViewById(R.id.login);
        btnLogin.setOnClickListener(v -> onLogin(v));


    }

    public void onLogin(View view) {

        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.show();

        Runnable loginTask = () -> {
            User user = new User("impatiencesnuffle", "mooBi8jais");
            CitiApplication.getCitiService().userLogin(user, Config.CLIENT_ID, new Callback<Auth>() {
                @Override
                public void success(Auth auth, Response response) {
                    dialog.dismiss();
                    if (auth.getToken() != null) {
                        CitiApplication.setToken(auth.getToken());
                        MainFragment fragment = new MainFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container, fragment)
                                .commit();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    dialog.dismiss();
                    Dump.e(error.toString());

                }
            });
        };

        Thread thread = new Thread(loginTask);
        thread.start();
    }

}
