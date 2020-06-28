package com.lmsourassf.librarymanagementsystem.mapper;

import com.lmsourassf.librarymanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    void deleteUser(int id);

    int countUser();
}
