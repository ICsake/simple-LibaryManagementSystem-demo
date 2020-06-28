package com.lmsourassf.librarymanagementsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmsourassf.librarymanagementsystem.pojo.Book;
import com.lmsourassf.librarymanagementsystem.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {


    @Autowired
    private BookServiceImpl bookServiceImpl;


    @GetMapping("/pagebooks/{page}/{size}")
    @ResponseBody
    public PageInfo<Book> lists(@PathVariable Integer page, @PathVariable("size") Integer size){
//        设置分页规则
        PageHelper.startPage(page,size);
//        返回所有分页信息参数为查询所有记录的信息
        List<Book> bookList = bookServiceImpl.pageBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
        return pageInfo;
    }

    @PostMapping("/savebook")
    public String save(@RequestBody Book book){
        Integer result = bookServiceImpl.addBook(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/queryBookById/{id}")
    public Book queryBookById(@PathVariable("id") Integer id){
        return bookServiceImpl.queryBookById(id);
    }

    @PutMapping("/updatebook")
    public String updateBook(@RequestBody Book book){
        Integer result = bookServiceImpl.updateBook(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }


    @DeleteMapping("/deletebookById/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookServiceImpl.deleteBook(id);
    }
}
