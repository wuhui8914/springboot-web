package com.xgxx.springboot.entities;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Dx
 * @Date 2020/9/27 15:16
 * @Version 1.0
 **/
@Document(indexName = "dongxin",type = "book")
public class Book {
    private Integer id;
    private String bookName;
    private String author;


    public Book() {
    }

    public Book(Integer id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
