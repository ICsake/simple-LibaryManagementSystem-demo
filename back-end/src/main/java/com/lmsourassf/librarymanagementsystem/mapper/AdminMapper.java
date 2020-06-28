package com.lmsourassf.librarymanagementsystem.mapper;

import com.lmsourassf.librarymanagementsystem.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface AdminMapper {
    Admin Login(Map<String,Object> map);
}
