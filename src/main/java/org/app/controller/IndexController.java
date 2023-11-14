package org.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class IndexController {


    @GetMapping("/test")
    public String testResult() {
        return "Hello SpringSecurity";
    }


    @GetMapping("/getValue")
    public String getValue() {

        return "0";
    }

    @GetMapping("/message.io")
    public String data() {
        return "Hello SpringSecurity";
    }
}
