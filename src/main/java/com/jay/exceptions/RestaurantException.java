package com.jay.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Failed to create restaurant")
public class RestaurantException extends RuntimeException{


    public RestaurantException(String msg){

        super(msg);

    }


}
