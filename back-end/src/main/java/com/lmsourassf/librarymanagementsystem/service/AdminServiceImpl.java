package com.lmsourassf.librarymanagementsystem.service;

import com.lmsourassf.librarymanagementsystem.mapper.AdminMapper;
import com.lmsourassf.librarymanagementsystem.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private  AdminMapper adminMapper;

    @Override
    public Admin checkLogin(String name, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("admin_name",name);
        map.put("admin_pwd",password);
        Admin admin = adminMapper.Login(map);
        if(admin!=null){
            return admin;
        }else{
            throw  new RuntimeException("用户名或密码错误");
        }
    }
}
