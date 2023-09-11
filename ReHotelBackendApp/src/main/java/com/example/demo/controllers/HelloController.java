package com.example.demo.controllers;

import com.example.demo.controllers.tools.RequestRunner;
import com.example.demo.usecases.HelloControllerUC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


import static com.example.demo.usecases.HelloControllerUC.*;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    HelloControllerUC uc;

    @GetMapping("/hello")
    public DeferredResult<HelloResponse> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new RequestRunner<HelloResponse>(logger).run(() -> uc.hello(name));
    }

    @GetMapping("/users")
    public DeferredResult<UsersResponse> users() {
        return new RequestRunner<UsersResponse>(logger).run(() -> uc.getUsers());
    }
}
