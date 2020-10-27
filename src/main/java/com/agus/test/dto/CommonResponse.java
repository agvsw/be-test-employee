package com.agus.test.dto;

public class CommonResponse<T> {
    private int responseCode;
    private String responseMessage;
    private T data;

    public CommonResponse(){
        this.responseCode= 20;
        this.responseMessage= "success";
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
