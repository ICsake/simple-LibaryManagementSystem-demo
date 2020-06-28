package com.lmsourassf.librarymanagementsystem.service;
import com.lmsourassf.librarymanagementsystem.pojo.User;

import java.util.List;

public interface UserService {

    List<User> pageUser();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    void deleteUser(int id);
}
