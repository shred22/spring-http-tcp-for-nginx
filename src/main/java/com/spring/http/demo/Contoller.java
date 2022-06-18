package com.spring.http.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.http.demo.model.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Contoller {


    @GetMapping("hello")
    public ResponseEntity<ResponseMessage> hello() {
        log.info("::::::: Request recieved ::::::");
        return ResponseEntity.ok(ResponseMessage.builder().message("hi client").build());
    }
}
