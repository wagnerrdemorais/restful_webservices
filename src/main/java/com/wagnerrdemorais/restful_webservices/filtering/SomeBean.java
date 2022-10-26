package com.wagnerrdemorais.restful_webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties("field1")
//@JsonFilter("myFilter")
public class SomeBean {

    String field1;

//    @JsonIgnore
    String field2;

    String field3;

    String field4;

    String field5;

}
