package com.example.api.parentchild.queryRegistr.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * 用戶角色返回body
 * strict/required:是否精確匹配
 */
@Root(name = "soap:Body", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class RegistRequestBody {

    @Element(name = "QueryRegistr", required = false)
    public RegistRequestModel QueryRegistr;

}

