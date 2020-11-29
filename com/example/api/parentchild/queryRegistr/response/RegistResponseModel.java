package com.example.api.parentchild.queryRegistr.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 用戶角色返回
 */
@Root(name = "QueryRegistrResponse")
@Namespace(reference = "http://tempuri.org/")
public class RegistResponseModel {

    @ElementList(name = "QueryRegistrResult")
    public List<RegistrModel> QueryRegistrResult;

}