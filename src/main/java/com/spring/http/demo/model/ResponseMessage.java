package com.spring.http.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
    private String message;
}
