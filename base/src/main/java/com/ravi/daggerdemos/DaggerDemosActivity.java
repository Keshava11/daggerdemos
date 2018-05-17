package com.ravi.daggerdemos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.ravi.daggerdemos.utils.LogUtils;
import com.ravi.daggerdemos.utils.ServiceUtils;

import javax.inject.Inject;

public class DaggerDemosActivity extends AppCompatActivity {

    @Inject
    ServiceUtils mServiceUtils;
    @Inject
    LogUtils mLogUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_demos);

        // Inflate the fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dagger_container, new DaggerDemosFragment(), "DaggerDemos").commit();

        // Inject dependency
        DaggerDemosApplication.getApp().getServiceComponent().inject(this);

        // Access Location
        initLocationAccess();

        // Using Dependencies in the following statements
        mLogUtils.logV("Begin of activity onCreate");

        if (mServiceUtils.networkCheckWithNotification()) {
            mLogUtils.logV("I will add an network call here");
        }

        initLocationAccess();

        mLogUtils.logV("End of activity onCreate");
    }

    void initLocationAccess() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 11);
        } else {
            mLogUtils.showToast(mServiceUtils.getLastLocation());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 11:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLogUtils.showToast(mServiceUtils.getLastLocation());
                }
                break;
        }
    }

}
