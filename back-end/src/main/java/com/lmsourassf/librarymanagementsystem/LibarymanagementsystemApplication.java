package com.lmsourassf.librarymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
public class LibarymanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibarymanagementsystemApplication.class, args);
    }

}
