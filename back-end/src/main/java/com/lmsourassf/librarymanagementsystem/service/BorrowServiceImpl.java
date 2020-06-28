package com.lmsourassf.librarymanagementsystem.service;

import com.lmsourassf.librarymanagementsystem.mapper.BookMapper;
import com.lmsourassf.librarymanagementsystem.mapper.BorrowMapper;
import com.lmsourassf.librarymanagementsystem.mapper.UserMapper;
import com.lmsourassf.librarymanagementsystem.pojo.Book;
import com.lmsourassf.librarymanagementsystem.pojo.BorrowBooks;
import com.lmsourassf.librarymanagementsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int borrowBook(int user_id, int book_id, Date borrow_date, Date due_date) {
        try {
            User user = userMapper.queryUserById(user_id);
            Book book = bookMapper.queryBookById(book_id);
            if(user!=null&& book !=null){
                BorrowBooks borrowBooks = new BorrowBooks(null,user.getId(),user.getName(),book.getId(),book.getName(),borrow_date,due_date);
                int result = borrowMapper.borrowBook(borrowBooks);
                return  result;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    @Override
    public void returnBook(int user_id, int book_id) {
        Map<String,Object> map = new HashMap<String,Object>();
       map.put("user_id",user_id);
       map.put("book_id",book_id);
        borrowMapper.returnBook(map);
    }


    @Override
    public List<BorrowBooks> pageBorrowBooks() {
        return borrowMapper.borrowList();
    }




}
