package com.example.api.parentchild.queryRegistr.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用戶角色返回body
 */
@Root(name = "Body")
public class RegistResponseBody {

    @Element(name = "QueryRegistrResponse", required = false)
    public RegistResponseModel QueryRegistrResponse;

}