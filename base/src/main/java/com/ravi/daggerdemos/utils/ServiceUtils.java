package com.ravi.daggerdemos.utils;

import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.ravi.daggerdemos.DaggerDemosApplication;

import javax.inject.Inject;


public class ServiceUtils {

    ConnectivityManager mConnectivityManager;

    @Inject
    LocationManager mLocationManager;

    @Inject
    LogUtils mMyAppUtils;

    @Inject
    public ServiceUtils(ConnectivityManager iConnectivityManager) {
        // Injecting dependencies through constructor
        mConnectivityManager = iConnectivityManager;

        // Injecting dependency through field that is Location manager
        DaggerDemosApplication.getApp().getServiceComponent().inject(this);
    }

    public boolean isNetworkAvailable() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public boolean networkCheckWithNotification(String... iMessage) {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        boolean networkAvailable = networkInfo != null && networkInfo.isConnected();

        if (!networkAvailable) {
            mMyAppUtils.showToast((iMessage != null &&
                    iMessage.length > 0 && !TextUtils.isEmpty(iMessage[0])) ? iMessage[0] : "No Internet Connection");
        }

        return networkAvailable;
    }

    public String getLastLocation() {

        Location location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        return location != null ? location.getLatitude() + " - " + location.getLongitude() : "Default";
    }

}
