package com.intraway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController("intraway/api")
public class Controller {
    /**
     *
     * @param min min number
     * @param max max number
     * @return response of processing fizzbuzz
     */
    @RequestMapping(value = "/fizzbuzz/{min}/{max}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String min, @PathVariable String max) {
        return "Hello " + min +  "!";
    }
}
