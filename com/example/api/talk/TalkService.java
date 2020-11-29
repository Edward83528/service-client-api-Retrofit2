package com.example.api.talk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface TalkService {

    @POST("???")
    Call<List<TalkResponse>> getTalkInfo(@Body TalkRequest talkRequest);
    
}
