package org.app.controller;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.RBody;
import org.app.request.IndexRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/index")
public class IndexController {


    @GetMapping("test")
    public String testResult(@RBody IndexRequest body) {

        System.out.println(body);
        System.out.println(body.getAge());

        return "Hello SpringSecurity";
    }
}
