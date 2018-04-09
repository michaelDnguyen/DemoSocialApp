package com.example.nntai.mycompanyapp.services;

import com.example.nntai.mycompanyapp.services.request.SiteVerifyRequest;
import com.example.nntai.mycompanyapp.services.response.SiteVerifyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceRequest {

    // upload image to server
//	@Streaming
//	@POST("SubmitPropsImage")
//	Call<SubmitPropImageResponse> submitPropImage(@Body BaseRequest request);
//
//	// get list notification from server
//	@POST("GetNotifications")
//	Call<GetNotificationsByAgentResponse> GetNotificationsByAgent(@Body BaseRequest request);

    // Post site verify reCaptcha
	@POST("siteverify")
	Call<SiteVerifyResponse> getSiteVerifyReCaptCha(@Body SiteVerifyRequest request);

}
