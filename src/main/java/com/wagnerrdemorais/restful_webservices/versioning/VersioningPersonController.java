package com.wagnerrdemorais.restful_webservices.versioning;

import com.wagnerrdemorais.restful_webservices.user.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersion() {
        return new PersonV1("Bob Rob");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersion() {
        return new PersonV2(Name.builder().firstName("Bob").lastName("Rob").build());
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionRequestParam() {
        return new PersonV1("Bob Rob");
    }

    @GetMapping(path ="/person", params = "version=2")
    public PersonV2 getSecondVersionRequestParam() {
        return new PersonV2(Name.builder().firstName("Bob").lastName("Rob").build());
    }

    @GetMapping(path ="/person-header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionHeader() {
        return new PersonV1("Bob Rob");
    }

    @GetMapping(path ="/person-header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionHeader() {
        return new PersonV2(Name.builder().firstName("Bob").lastName("Rob").build());
    }

    @GetMapping(path ="/person/accept", produces = "application/vnd.app-v1+json")
    public PersonV1 getFirstVersionAccept() {
        return new PersonV1("Bob Rob");
    }

    @GetMapping(path ="/person/accept", produces = "application/vnd.app-v2+json")
    public PersonV2 getSecondVersionAccept() {
        return new PersonV2(Name.builder().firstName("Bob").lastName("Rob").build());
    }

}
