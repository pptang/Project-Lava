package com.money.lava.deal.application;

import android.app.Application;

import com.money.lava.deal.api.CitiService;
import com.money.lava.deal.config.Config;

import retrofit.RestAdapter;

public class CitiApplication extends Application {

    private static String myToken = null;
    private static CitiService citiService = null;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static CitiService getCitiService() {
        CitiService service = citiService;
        if (citiService == null) {
            synchronized (CitiApplication.class) {
                if (citiService == null) {
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint(Config.BASE_URL)
                            .build();
                    citiService = restAdapter.create(CitiService.class);
                }
            }
        }
        return citiService;
    }

    public static String getToken() {
        if (myToken != null) {
            return myToken;
        }
        return "";
    }

    public static void setToken(String token) {
        if (token.length() != 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Bearer ");
            builder.append(token);
            myToken = builder.toString();
        }
    }




}
