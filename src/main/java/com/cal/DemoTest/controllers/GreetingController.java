package com.cal.DemoTest.controllers;

import com.cal.DemoTest.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
        return new Greeting(counter.incrementAndGet(), "Hello unnamed person!");
    }
}
