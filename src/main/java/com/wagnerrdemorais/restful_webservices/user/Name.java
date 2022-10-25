package com.wagnerrdemorais.restful_webservices.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Name {

    private String firstName;
    private String lastName;
}
