package com.example.LocalDelicacies;

import android.app.Application;
import com.squareup.otto.Bus;
import events.BaseEvent;

/**
 * Created by bnegron on 7/21/14.
 */
public class AppBus extends Application{
    private static AppBus instance = new AppBus();
    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        instance.bus = new Bus();
    }

    public static AppBus getInstance(){
        return instance;
    }

    public Bus getBus(){
        return bus;
    }

    public static void postToBus(BaseEvent event) {
        getInstance().getBus().post(event);
    }
}
