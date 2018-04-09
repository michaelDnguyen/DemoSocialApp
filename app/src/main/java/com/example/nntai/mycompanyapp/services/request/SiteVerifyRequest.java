package com.example.nntai.mycompanyapp.services.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nn.tai on 03/04/2018.
 */

public class SiteVerifyRequest {
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("remoteip")
    @Expose
    private String remoteip;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRemoteip() {
        return remoteip;
    }

    public void setRemoteip(String remoteip) {
        this.remoteip = remoteip;
    }
}
