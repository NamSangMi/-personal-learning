package com.namsangmi.learning.http;

public interface RequestCallBack {
    void start();

    void error(String errorMsg);

    void next(Object object);
}
