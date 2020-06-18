package com.namsangmi.learning.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.namsangmi.learning.PLApplication;

public class Tools {

    /**
     * 是否有网络
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        Context context = PLApplication.getInstance();
        if (context == null) {
            return false;
        }
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = null;
        if (mConnectivityManager != null) {
            mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        }
        if (mNetworkInfo == null) {
            return false;
        }
        return mNetworkInfo.isAvailable();
    }
}
