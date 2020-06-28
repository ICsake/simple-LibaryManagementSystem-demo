package com.lmsourassf.librarymanagementsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmsourassf.librarymanagementsystem.pojo.BorrowBooks;
import com.lmsourassf.librarymanagementsystem.pojo.User;
import com.lmsourassf.librarymanagementsystem.service.BorrowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class BorrowController {

    @Autowired
    private BorrowServiceImpl borrowServiceImpl;

    @PostMapping("/borrowbook/{user_id}/{book_id}/{borrow_date}/{due_date}")
    public String borrowBook(@PathVariable("user_id") int user_id, @PathVariable("book_id") int book_id, @PathVariable("borrow_date") Date borrow_date,  @PathVariable("due_date") Date due_date){
        int result = borrowServiceImpl.borrowBook(user_id, book_id, borrow_date, due_date);
        if(result!=0){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/returnbook/{user_id}/{book_id}")
    public void returnBook(@PathVariable("user_id")Integer user_id, @PathVariable("book_id") Integer book_id){
        borrowServiceImpl.returnBook(user_id,book_id);
    }


    @GetMapping("/borrowlist/{page}/{size}")
    public PageInfo<BorrowBooks> lists(@PathVariable Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<BorrowBooks> borrowlist = borrowServiceImpl.pageBorrowBooks();
        PageInfo<BorrowBooks> pageInfo = new PageInfo<>(borrowlist);
        return pageInfo;
    }
}
