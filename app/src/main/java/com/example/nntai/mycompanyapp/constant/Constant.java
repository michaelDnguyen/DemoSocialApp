package com.example.nntai.mycompanyapp.constant;

import java.util.logging.Level;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by nn.tai on 03/04/2018.
 */

public class Constant {

    public final String TAG = this.getClass().getSimpleName();

    public static final String URL = "";

    public static final String URL_VERIFY_CAPTCHA = "https://www.google.com/recaptcha/api/";

    public static final HttpLoggingInterceptor.Level LogRetrofit = HttpLoggingInterceptor.Level.BODY;
}
