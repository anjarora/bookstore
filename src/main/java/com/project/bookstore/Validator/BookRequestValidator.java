package com.project.bookstore.Validator;

import com.project.bookstore.domain.BookBean;
import org.apache.commons.validator.routines.ISBNValidator;

public class BookRequestValidator {

    private static final ISBNValidator isbnValidator = ISBNValidator.getInstance();

    public static boolean isValidRequest(BookBean bookBean){
        if(!isbnValidator.isValid(bookBean.getIsbn())){
           return false;
        }
        return true;
    }
}
