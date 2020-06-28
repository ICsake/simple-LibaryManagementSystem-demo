package com.lmsourassf.librarymanagementsystem.service;

import com.lmsourassf.librarymanagementsystem.mapper.BookMapper;
import com.lmsourassf.librarymanagementsystem.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookmapper;

    public List<Book> pageBook() {
        return bookmapper.queryBookList();
    }

    public int addBook(Book book){
        return bookmapper.addBook(book);
    }

    public Book queryBookById(int id){
        return bookmapper.queryBookById(id);
    }

    public int updateBook(Book book){
        return bookmapper.updateBook(book);
    }

    public void deleteBook(int id){
         bookmapper.deleteBook(id);
    }
}
