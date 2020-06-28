package com.lmsourassf.librarymanagementsystem.service;

import com.lmsourassf.librarymanagementsystem.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> pageBook();

    int addBook(Book book);

    Book queryBookById(int id);

    int updateBook(Book book);

    void deleteBook(int id);
}
