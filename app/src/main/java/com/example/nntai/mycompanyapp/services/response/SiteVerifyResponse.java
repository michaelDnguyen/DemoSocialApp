package com.example.nntai.mycompanyapp.services.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nn.tai on 03/04/2018.
 */

public class SiteVerifyResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("challenge_ts")
    @Expose
    private Integer challengeTs;
    @SerializedName("apk_package_name")
    @Expose
    private String apkPackageName;
    @SerializedName("error-codes")
    @Expose
    private String errorCodes;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getChallengeTs() {
        return challengeTs;
    }

    public void setChallengeTs(Integer challengeTs) {
        this.challengeTs = challengeTs;
    }

    public String getApkPackageName() {
        return apkPackageName;
    }

    public void setApkPackageName(String apkPackageName) {
        this.apkPackageName = apkPackageName;
    }

    public String getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(String errorCodes) {
        this.errorCodes = errorCodes;
    }
}
