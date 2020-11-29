package com.example.api.talk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TalkRequest {

    @JsonProperty("api_key")
    private String apikey; // 申請取得

    @JsonProperty("uuid")
    private String uuid; // UUID

    @JsonProperty("start_date")
    private String startDate; // 案件登錄日期起(預設範圍為90天格式： 2010-01-01 00:00:00)

    @JsonProperty("end_date")
    private String endDate; // 案件登錄日期迄(預設範圍為90天格式： 2010-01-01 00:00:00)

}
