package com.tde.apipagabus.domain.response;


import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    // Getters y setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
