
package com.project.bookstore.domain;

import javax.validation.constraints.NotNull;

public class OrderBean {

    @NotNull
    private String purchasedBy;

    @NotNull
    private BookBean book;

    public OrderBean(String purchasedBy, BookBean book) {
        this.purchasedBy = purchasedBy;
        this.book = book;
    }

    public String getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(String purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }
}
