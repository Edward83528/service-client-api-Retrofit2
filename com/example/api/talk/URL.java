package com.example.api.talk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class URL {

    @JsonProperty("url")
    private String url;

}
