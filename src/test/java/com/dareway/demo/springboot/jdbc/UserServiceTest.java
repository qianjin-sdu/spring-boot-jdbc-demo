package com.dareway.demo.springboot.jdbc;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;

@SpringBootTest(classes = com.dareway.SpringBootApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userservice;

    @org.junit.Test
    public void createUser() throws Exception{
        String appid = "TestApp";
        String appName = "TestApp";
        String parent = "";
        String appType = "";
        UserInfo ui ;
        userservice.purecreateUser(appid,appName,parent,appType);
//        ui = userservice.getUser(appid);
//        if(null != ui){
//            userservice.deleteUserByUserId(appid);
//        }
//        userservice.createUser(appid,appName,parent,appType);
    }

    @org.junit.Test
    public void getUser() {
    }

    @org.junit.Test
    public void deleteUserByUserId() {
    }
}
