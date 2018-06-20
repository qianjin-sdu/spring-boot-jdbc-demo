package com.dareway.demo.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public void purecreateUser(String appid,String appName,String parent,String appType) throws Exception{
        userInfoMapper.purecreateUser(appid,appName,parent,appType);
    }

    public void createUser(String appid,String appName,String parent,String appType) throws Exception{
        userInfoMapper.createUser(appid,appName,parent,appType);
    }

    public UserInfo getUser(String appid) throws Exception {
        return userInfoMapper.getUser(appid);
    }


    public void deleteUserByUserId(String appid) throws Exception {
        userInfoMapper.deleteUserByUserId(appid);
    }
}
