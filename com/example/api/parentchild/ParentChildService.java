package com.example.api.parentchild;

import com.example.api.parentchild.queryRegistr.request.RegistRequestEnvelope;
import com.example.api.parentchild.queryRegistr.response.RegistResponseEnvelope;
import com.example.api.parentchild.queryVisit.request.VisitRequestEnvelope;
import com.example.api.parentchild.queryVisit.response.VisitResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 接口請求
 */
public interface ParentChildService {

    @Headers({"Content-Type: text/xml;charset=UTF-8", "SOAPAction: http://"})
    @POST("??.asmx")
    Call<RegistResponseEnvelope> queryRegistr(@Body RegistRequestEnvelope registRequestEnvelope);

}