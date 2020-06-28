package com.lmsourassf.librarymanagementsystem.controller;

import com.lmsourassf.librarymanagementsystem.core.RetResponse;
import com.lmsourassf.librarymanagementsystem.core.RetResult;
import com.lmsourassf.librarymanagementsystem.pojo.Admin;
import com.lmsourassf.librarymanagementsystem.service.AdminService;
import com.lmsourassf.librarymanagementsystem.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public RetResult<Admin> checkLogin(@RequestBody Admin admin){
        try {
            Admin adminInfo = adminServiceImpl.checkLogin(admin.getName(),admin.getPwd());
            return RetResponse.makeOKRsp(adminInfo);
        }catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

}
