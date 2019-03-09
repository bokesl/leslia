package com.leslia.test.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leslia.api.api.BookService;
import com.leslia.api.pojo.Book;
import com.leslia.ware.base.BaseTestDubbo;
import org.junit.Test;

import java.util.Date;

public class BookServiceTest extends BaseTestDubbo {

    @Reference
    private BookService bookService;

    @Test
    public void insertBook(){
        Book book=new Book();
        book.setBookName("神奇校车");
        book.setAuthor("乔安娜柯尔");
        book.setCreateTime(new Date());
        bookService.insertBook1(book);
    }

    @Test
    public void selectBook(){
        Book book=bookService.selectBook(2);
        System.out.println(book.toString());
    }



}