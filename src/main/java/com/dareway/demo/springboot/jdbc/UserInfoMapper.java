package com.dareway.demo.springboot.jdbc;

public interface UserInfoMapper {
    void purecreateUser(String appid,String appName,String parent,String appType) throws Exception;

    void createUser(String appid,String appName,String parent,String appType) throws Exception;

    UserInfo getUser(String appid) throws Exception;

    void deleteUserByUserId(String appid) throws Exception;
}
