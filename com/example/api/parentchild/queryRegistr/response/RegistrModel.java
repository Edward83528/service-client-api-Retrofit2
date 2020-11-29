package com.example.api.parentchild.queryRegistr.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "QueryRegistrResult")
public class RegistrModel {

    @Element(name = "id")
    public Integer id; // 報名流水號

    @Element(name = "vsit_name")
    public String vsitName; // 館舍名稱

    @Element(name = "reg_title")
    public String regTitle; // 活動名稱

    @Element(name = "reg_act_bdate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public String regActBdate; // 活動日期 dateTime

    @Element(name = "data_pdate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public String dataPdate; // 報名日期 dateTime

    @Element(name = "data_RegState")
    public String dataRegState; // 狀態

}
