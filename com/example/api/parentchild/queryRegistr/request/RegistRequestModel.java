package com.example.api.parentchild.queryRegistr.request;

import org.simpleframework.xml.Element;

/**
 * 獲取具體信息需要回傳的參數
 */
public class RegistRequestModel {

    @Element(name = "sub")
    public String sub; // 身分證字號

}

