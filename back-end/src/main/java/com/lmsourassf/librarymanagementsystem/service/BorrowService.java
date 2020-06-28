package com.lmsourassf.librarymanagementsystem.service;


import com.lmsourassf.librarymanagementsystem.pojo.BorrowBooks;
import com.lmsourassf.librarymanagementsystem.pojo.User;

import java.util.Date;
import java.util.List;

public interface BorrowService {

    int borrowBook(int user_id,  int book_id,  Date borrow_date, Date due_date);

    void returnBook(int user_id, int book_id);

    List<BorrowBooks> pageBorrowBooks();
}

