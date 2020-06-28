package com.lmsourassf.librarymanagementsystem.service;

import com.lmsourassf.librarymanagementsystem.mapper.AdminMapper;
import com.lmsourassf.librarymanagementsystem.pojo.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {

    Admin checkLogin(String name, String pwd);
}
