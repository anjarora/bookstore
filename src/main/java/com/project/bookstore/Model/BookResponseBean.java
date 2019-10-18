package com.project.bookstore.Model;

import com.project.bookstore.domain.BookBean;

public class BookResponseBean {

    private String id;
    private BookBean bookBean;

    public BookResponseBean(String id) {
        this.id = id;
    }

    public BookResponseBean(String id, BookBean bookBean) {
        this.id = id;
        this.bookBean = bookBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }
}
