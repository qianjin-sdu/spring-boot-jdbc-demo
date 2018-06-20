package com.dareway.demo.springboot.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserInfoImpl implements UserInfoMapper{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void purecreateUser(String appid,String appName,String parent,String appType) throws Exception{
        UserInfo ui = getUser(appid);
        if(null != ui){
            System.out.println("["+appid+"] deleting.");
            deleteUserByUserId(appid);
        }
        Thread.sleep(5000);
        ui = getUser(appid);
        if(null != ui){
            System.out.println(ui.toString());
        }else{
            System.out.println("["+appid+"] deleted.");
        }
        createUser(appid,appName,parent,appType);
    }

    @Transactional(propagation = Propagation.NESTED,rollbackFor={Exception.class})
    public void createUser(String appid,String appName,String parent,String appType) throws Exception {
        final int update= jdbcTemplate.update("INSERT INTO sep.app_info(appid,appname,parent,apptype) VALUES (?,?,?,?)", appid, appName, parent, appType);
    }

    public UserInfo getUser(String appid) {
        List<UserInfo> userList = jdbcTemplate.query("select appid,appName,parent,appType FROM sep.app_info WHERE appid = ?",new Object[]{appid},new BeanPropertyRowMapper(UserInfo.class));
        if(userList != null && userList.size() > 0){
            UserInfo user = userList.get(0);
            return user;
        }else {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
    public void deleteUserByUserId(String appid) throws Exception{
        final int update = jdbcTemplate.update("DELETE FROM sep.app_info WHERE appid = ?", appid);
        throw new Exception("delete err");
    }
}
