package com.example.nntai.mycompanyapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nntai.mycompanyapp.constant.myLog;
import com.zing.zalo.zalosdk.oauth.LoginForm;
import com.zing.zalo.zalosdk.oauth.LoginVia;
import com.zing.zalo.zalosdk.oauth.OAuthCompleteListener;
import com.zing.zalo.zalosdk.oauth.OauthResponse;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;

public class ZaloActivity extends Activity {

    Button btnZaloLogin;
    TextView tvZaloInfo;
    LoginForm loginForm;

    OAuthCompleteListener zaloLoginCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zalo);
        getViews();
        setListener();
    }

    private void getViews() {
        btnZaloLogin = (Button) findViewById(R.id.btnZaloLogin);

        tvZaloInfo = (TextView) findViewById(R.id.tvZaloInfo);

        loginForm = (LoginForm) findViewById(R.id.login_form);
        loginForm.setZaloLoginVia(LoginVia.APP_OR_WEB);
        loginForm.setOAuthCompleteListener(new OAuthCompleteListener(){
            @Override
            public void onGetOAuthComplete(OauthResponse response) {
                super.onGetOAuthComplete(response);
                myLog.e("Success " + response.toString());
            }

            @Override
            public void onAuthenError(int errorCode, String message) {
                super.onAuthenError(errorCode, message);
                myLog.e("Authen Error = " + message);
            }
        });
    }

    private void setListener(){

        btnZaloLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ZaloSDK.Instance.onActivityResult(this, requestCode, resultCode, data);
        if (loginForm != null){
            loginForm.onActivityResult(this, requestCode, resultCode, data);
        }
    }
}
