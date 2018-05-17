package com.ravi.daggerdemos.di;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;

import com.ravi.daggerdemos.utils.LogUtils;
import com.ravi.daggerdemos.utils.ServiceUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    private Context mApplication;

    public ServiceModule(Context iApplication) {
        mApplication = iApplication;
    }

    @Provides
    @Singleton
    public ServiceUtils getMyAppServiceManager() {
        return new ServiceUtils(getConnectivityManager());
    }

    // this is not be used directly but through ServiceUtils
    private ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) mApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    public LocationManager getLocationManager() {
        return (LocationManager) mApplication.getSystemService(Context.LOCATION_SERVICE);
    }

    @Singleton
    @Provides
    public LogUtils provideMyAppUtils(){
        return new LogUtils();
    }

}
