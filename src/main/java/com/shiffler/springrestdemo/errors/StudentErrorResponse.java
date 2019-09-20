/**
 * This class will be used to build an error response to a bad request to the Student API
 *
 */

package com.shiffler.springrestdemo.errors;

import lombok.Data;

@Data
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timestamp;


    public StudentErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }



}
