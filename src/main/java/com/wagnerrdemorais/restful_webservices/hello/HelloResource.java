package com.wagnerrdemorais.restful_webservices.hello;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloResource {

    private final MessageSource messageSource;

    public HelloResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/another_hello/name/{name}")
    public String anotherHello(@PathVariable String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/international_hello/name/{name}")
    public String internationalHello(@PathVariable String name) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("hello", null, "Default Message", locale);
        return message +  name;
    }
}
