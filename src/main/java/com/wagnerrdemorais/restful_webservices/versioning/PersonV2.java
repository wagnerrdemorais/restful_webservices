package com.wagnerrdemorais.restful_webservices.versioning;

import com.wagnerrdemorais.restful_webservices.user.Name;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonV2 {

    private Name name;
}
