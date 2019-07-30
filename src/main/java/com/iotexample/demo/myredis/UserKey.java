package com.iotexample.demo.myredis;

public class UserKey extends BasePrefix {
  private static final int EXPIRE_SECONDS = 10 * 60;

  private UserKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }

  public static UserKey token = new UserKey(EXPIRE_SECONDS, "tk");
  public static UserKey getByName = new UserKey(EXPIRE_SECONDS, "tk");

}
