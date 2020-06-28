package com.lmsourassf.librarymanagementsystem.mapper;

import com.lmsourassf.librarymanagementsystem.pojo.BorrowBooks;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BorrowMapper {

    int borrowBook(BorrowBooks borrowBooks);

    void returnBook( Map<String,Object> map);

    List<BorrowBooks> borrowList();

}
