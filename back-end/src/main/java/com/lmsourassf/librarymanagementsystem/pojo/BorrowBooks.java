package com.lmsourassf.librarymanagementsystem.pojo;

import java.util.Date;

public class BorrowBooks {
    private Integer id;
    private Integer user_id;
    private String user_name;
    private Integer book_id;
    private String book_name;
    private Date borrow_date;
    private Date due_date;

    public BorrowBooks(Integer id, Integer user_id, String user_name, Integer book_id, String book_name, Date borrow_date, Date due_date) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.book_id = book_id;
        this.book_name = book_name;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
    }

    public BorrowBooks() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "BorrowBooks{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", borrow_date=" + borrow_date +
                ", due_date=" + due_date +
                '}';
    }
}
