package com.ravi.daggerdemos;

import android.app.Application;

import com.ravi.daggerdemos.di.DaggerServiceComponent;
import com.ravi.daggerdemos.di.ServiceComponent;
import com.ravi.daggerdemos.di.ServiceModule;

public class DaggerDemosApplication extends Application {

    private static DaggerDemosApplication sDaggerDemosApplication;
    private ServiceComponent mServiceComponent;

    public static DaggerDemosApplication getApp() {
        return sDaggerDemosApplication;
    }

    public ServiceComponent getServiceComponent() {
        return mServiceComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sDaggerDemosApplication = this;

        // Initialize Service Component
        mServiceComponent = DaggerServiceComponent.builder()
                .serviceModule(new ServiceModule(this)).build();
    }

}
