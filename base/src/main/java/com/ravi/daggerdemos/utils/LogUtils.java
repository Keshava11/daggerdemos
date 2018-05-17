package com.ravi.daggerdemos.utils;

import android.util.Log;
import android.widget.Toast;

import com.ravi.daggerdemos.DaggerDemosApplication;

public class LogUtils {

    private static final String TAG = LogUtils.class.getSimpleName();
    private static final boolean DEBUG = true;

    public void showToast(String iMessage) {
        Toast.makeText(DaggerDemosApplication.getApp(), iMessage, Toast.LENGTH_SHORT).show();
    }

    public void logE(String iMessage) {
        if (DEBUG)
            Log.e(TAG, iMessage);
    }

    public void logD(String iMessage) {
        if (DEBUG)
            Log.d(TAG, iMessage);
    }

    public void logV(String iMessage) {
        if (DEBUG)
            Log.v(TAG, iMessage);
    }

    public void logW(String iMessage) {
        if (DEBUG)
            Log.w(TAG, iMessage);
    }

    public void logI(String iMessage) {
        if (DEBUG)
            Log.i(TAG, iMessage);
    }

}
