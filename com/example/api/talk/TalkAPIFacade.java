package com.example.api.talk;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
public final class TalkAPIFacade {

    public static List<TalkResponse> getTalkInfo(TalkService talkService, TalkRequest talkRequest) {
        List<TalkResponse> talkResponse;
        Call<List<TalkResponse>> talkResponseCall = talkService.getTalkInfo(talkRequest);
        try {
            Response<List<TalkResponse>> response = talkResponseCall.execute();
            if (response.isSuccessful()) {
                talkResponse = response.body();
            } else {
                talkResponse = null;
            }

        } catch (IOException e) {
            Log.error("", e);
            talkResponse = null;
        }
        return talkResponse;
    }

    private TalkAPIFacade() {
        super();
    }

}
