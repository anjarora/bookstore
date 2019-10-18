
package com.project.bookstore.entity;

import java.util.List;

public class Order {

    private String purchasedBy;
    List<BookEntity> books;

   public Order(){

    }

    public String getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(String purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public Order(String purchasedBy, List<BookEntity> books) {
        this.purchasedBy = purchasedBy;
        this.books = books;
    }


}
