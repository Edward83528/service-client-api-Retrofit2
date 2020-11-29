package com.example.api.talk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TalkResponse {

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("service_request_id")
    private String serviceRequestId; // 案件編號(唯一值不可重覆,例 106-A123456)

    @JsonProperty("status")
    private String status; // 案件狀態(待確認、待分派、待處理、已處理、不入案、非本府權責)

    @JsonProperty("service_code")
    private String serviceCode; // 派案類別識別碼(唯一值不可重覆,例： A0801)

    @JsonProperty("service_name")
    private String serviceName; // 派案類別名稱(例： 坡地違規開發檢舉案件)

    @JsonProperty("subject")
    private String subject; // 案件主旨

    @JsonProperty("description")
    private String description; // 案件內容描述

    @JsonProperty("address_string")
    private String addressString; // 發生地點

    @JsonProperty("media_url")
    private ArrayList<URL> mediaUrl; // 附加檔 URL(格式JSON/XML)

    @JsonProperty("requested_datetime")
    private String requestedDatetime; // 案件通報時間(格式： 2010-01-01T00:00:00)

    @JsonProperty("dispatch")
    private ArrayList<Dispatch> dispatch; // 承辦機關單位(格式JSON/XML)

}
