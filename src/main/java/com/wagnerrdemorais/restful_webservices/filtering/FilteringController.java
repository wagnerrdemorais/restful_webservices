package com.wagnerrdemorais.restful_webservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("field 1", "field 2", "value 3", "value 4", "value 5");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .serializeAll();
//
//        FilterProvider filters = new SimpleFilterProvider()
//                .addFilter("myFilter", filter);
//
//        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering_list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeans = List.of(new SomeBean("field 1", "field 2", "value 3", "value 4", "value 5"),
                new SomeBean("field 1", "field 2", "value 3", "value 4", "value 5"),
                new SomeBean("field 1", "field 2", "value 3", "value 4", "value 5"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2, field4");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", filter);
//
//        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
