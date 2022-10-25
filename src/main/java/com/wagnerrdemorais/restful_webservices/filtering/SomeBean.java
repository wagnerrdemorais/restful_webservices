package com.wagnerrdemorais.restful_webservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties("field1")
public class SomeBean {

    private String field1;

    @JsonIgnore
    private String field3;

    private String field2;
}
