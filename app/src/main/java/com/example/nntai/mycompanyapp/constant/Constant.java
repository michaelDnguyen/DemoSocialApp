package com.example.nntai.mycompanyapp.constant;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public static final boolean isDebug = true;



    public static String getApplicationHashKey(Context ctx) {
        try {
            PackageInfo info = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sig = Base64.encodeToString(md.digest(), Base64.DEFAULT).trim();
                if (sig.trim().length() > 0) {
                    return sig;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        return "";
    }
}
