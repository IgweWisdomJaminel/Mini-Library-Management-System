package com.jaminel.minilibrary.response;

import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object>responseBuilder(String message, HttpStatus httpStatus,Object responseHandler){
        Map<String, Object> response = new HashMap<>();
        response.put("message",message);
        response.put("httpStatus",httpStatus);
        response.put("reponsehandler",responseHandler);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
