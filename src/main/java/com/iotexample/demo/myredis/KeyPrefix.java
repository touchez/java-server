package com.iotexample.demo.myredis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
