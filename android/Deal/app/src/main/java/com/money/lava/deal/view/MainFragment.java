package com.money.lava.deal.view;

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

public class MainFragment extends Fragment {

    private Button btnClick;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View view) {
        Button btnLogin = (Button) view.findViewById(R.id.login);
        btnLogin.setOnClickListener(v -> onLogin(v));

        Button btnGetAccountInfo = (Button) view.findViewById(R.id.getAccountInfo);
        btnGetAccountInfo.setOnClickListener(v -> onGetAccountInfo(v));
    }

    public void onLogin(View view) {
        Runnable loginTask = () -> {
            User user = new User("impatiencesnuffle", "mooBi8jais");
            CitiApplication.getCitiService().userLogin(user, Config.CLIENT_ID, new Callback<Auth>() {
                @Override
                public void success(Auth auth, Response response) {
                    Alert.show(getActivity(), "Hello:" + auth.getUsername());
                    if (auth.getToken() != null) {
                        CitiApplication.setToken(auth.getToken());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Dump.e(error.toString());

                }
            });
        };

        Thread thread = new Thread(loginTask);
        thread.start();
    }

    public void onGetAccountInfo(View view) {
        Runnable getAccountInfoTask = () -> {
            Dump.e(CitiApplication.getToken());
            CitiApplication.getCitiService().getUserAccountInfo(CitiApplication.getToken(),
                    Config.CLIENT_ID, new Callback<UserAccount>() {

                        @Override
                        public void success(UserAccount userAccount, Response response) {
                            Alert.show(getActivity(), userAccount.getAccountStatus());

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Dump.e(error.toString());

                        }

                    });
        };

        Thread thread = new Thread(getAccountInfoTask);
        thread.start();
    }
}
