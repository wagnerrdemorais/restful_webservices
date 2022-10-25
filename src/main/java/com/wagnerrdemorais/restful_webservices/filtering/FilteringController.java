package com.wagnerrdemorais.restful_webservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("field 1", "field 2", "value 3");
    }

    @GetMapping("/filteringList")
    public List<SomeBean> filteringList() {
        return List.of(new SomeBean("field 1", "field 2", "value 3"),
                new SomeBean("field 1", "field 2", "value 3"),
                new SomeBean("field 1", "field 2", "value 3"));
    }
}
