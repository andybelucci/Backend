package com.anderson.booksale.resources;

import lombok.Getter;

@Getter
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;

    public StandardError() {
    }

    public StandardError(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }
}
