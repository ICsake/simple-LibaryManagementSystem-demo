package com.lmsourassf.librarymanagementsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmsourassf.librarymanagementsystem.pojo.Book;
import com.lmsourassf.librarymanagementsystem.pojo.User;
import com.lmsourassf.librarymanagementsystem.service.UserService;
import com.lmsourassf.librarymanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/userpages/{page}/{size}")
    public PageInfo<User> lists(@PathVariable Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<User> userList = userServiceImpl.pageUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @PostMapping("/saveuser")
    public String save(@RequestBody User user){
        Integer result = userServiceImpl.addUser(user);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") Integer id){
        return userServiceImpl.queryUserById(id);
    }

    @PutMapping("/updateuser")
    public String updateUser(@RequestBody User user){
        Integer result = userServiceImpl.updateUser(user);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }


    @DeleteMapping("/deleteUserById/{id}")
    public void delete(@PathVariable("id") Integer id){
        userServiceImpl.deleteUser(id);
    }
}
