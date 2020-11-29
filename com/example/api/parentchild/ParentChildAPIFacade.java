package com.example.api.parentchild;

import com.example.api.parentchild.queryRegistr.request.RegistRequestEnvelope;
import com.example.api.parentchild.queryRegistr.response.RegistResponseEnvelope;
import com.example.api.parentchild.queryVisit.request.VisitRequestEnvelope;
import com.example.api.parentchild.queryVisit.response.VisitResponseEnvelope;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public final class ParentChildAPIFacade {

    public static RegistResponseEnvelope getRegistInfo(ParentChildService parentChildService, RegistRequestEnvelope registRequestEnvelope) {
        RegistResponseEnvelope registResponseEnvelope;
        Call<RegistResponseEnvelope> registResponseEnvelopeCall = parentChildService.queryRegistr(registRequestEnvelope);
        try {
            Response<RegistResponseEnvelope> response = registResponseEnvelopeCall.execute();
            if (response.isSuccessful()) {
                registResponseEnvelope = response.body();
            } else {
                registResponseEnvelope = null;
            }

        } catch (IOException e) {
            Log.error("", e);
            registResponseEnvelope = null;
        }
        return registResponseEnvelope;
    }

    private ParentChildAPIFacade() {
        super();
    }

}
