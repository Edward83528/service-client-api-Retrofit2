package com.example.api.talk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dispatch {

    @JsonProperty("dispatch_no")
    private String dispatchNo; // 府收文號(十碼，例:10500093156)

    @JsonProperty("agency_topresponsible_code")
    private String agencyTopresponsibleCode; // 承辦一級機關代碼(例:387290000H)

    @JsonProperty("agency_topresponsible")
    private String agencyTopresponsible; // 承辦一級機關名稱(例:交通局)

    @JsonProperty("agency_responsible_code")
    private String agencyResponsible_code; // 承辦單位代碼(依階層顯示,代碼以「/」隔開,例:387290100H/290103)

    @JsonProperty("agency_responsible")
    private String agencyResponsible; // 承辦單位名稱(依階層顯示,例:公共運輸處/營運管理課)

    @JsonProperty("task_code")
    private String taskCode; // 業務分類代碼(例:02)

    @JsonProperty("task")
    private String task; // 業務分類名稱(例:公車站牌新增、修復、遷移建設)

    @JsonProperty("officer")
    private String officer; // 承辦人

    @JsonProperty("phone")
    private String phone; // 承辦人電話

    @JsonProperty("dispatch_datetime")
    private String dispatchDatetime; // 案件分文時間(格式：2010-01-01 00:00:00)

    @JsonProperty("expected_datetime")
    private String expextedDatetime; // 案件預計完成時間(格式：2010-01-01 00:00:00)

    @JsonProperty("closed_datetime")
    private String closedDatetime; // 案件實際完成時間(格式：2010-01-01 00:00:00)

    @JsonProperty("expected_days")
    private String expectedDays; // 限辦天數(處理時限，整數字)

    @JsonProperty("expected_unit")
    private String expectedUnit; // 限辦計算單位(天、小時)

    @JsonProperty("expected_method")
    private String expectedMethod; // 限辦計算方式(工作天、日曆天)

    @JsonProperty("reply_content")
    private String replyContent; // 答覆處理內容

    @JsonProperty("status_notes")
    private String statusNotes; // 承辦案件狀態說明(提供給民眾查詢的狀態，例:待確認、待分派、待辦中、註銷、已處理)

}
