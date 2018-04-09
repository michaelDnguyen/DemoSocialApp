package com.example.nntai.mycompanyapp.constant;

import android.util.Log;

/**
 * Created by nn.tai on 09/04/2018.
 */

public class myLog {

    private static final String TAG = myLog.class.getSimpleName();

    public static void printTrace(Exception e) {
        if (Constant.isDebug)
            e.printStackTrace();
    }

    public static void d(String tag, String message) {
        if (Constant.isDebug)
            Log.d(tag, message);
    }

    public static void d(String message) {
        if (Constant.isDebug)
            Log.d(TAG, message);
    }

    public static void e(String tag, String message) {
        if (Constant.isDebug)
            Log.e(tag, message);
    }

    public static void e(String message) {
        if (Constant.isDebug)
            Log.e(TAG, message);
    }

    public static void i(String tag, String message) {
        if (Constant.isDebug)
            Log.i(tag, message);
    }

    public static void i(String message) {
        if (Constant.isDebug)
            Log.i(TAG, message);
    }

    public static void w(String tag, String message) {
        if (Constant.isDebug)
            Log.w(tag, message);
    }

    public static void w(String message) {
        if (Constant.isDebug)
            Log.w(TAG, message);
    }
}
