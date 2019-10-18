package com.project.bookstore.controller;

import com.project.bookstore.Model.BookResponseBean;
import com.project.bookstore.Model.BookingServiceSuccessResponse;
import com.project.bookstore.domain.BookBean;
import com.project.bookstore.domain.OrderBean;
import com.project.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;


@Controller
@Validated
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class BookController {

    private final BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<BookResponseBean> addNewBook(@RequestBody @Valid BookBean bookBean) throws Exception {
        return new ResponseEntity<BookResponseBean>(bookService.addBookToStore(bookBean), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity<BookResponseBean> getBookByIsbn(@RequestParam(value = "isbn", required = false) String isbn, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "author", required = false) String author) {
        return new ResponseEntity<BookResponseBean>(bookService.getBookByIsbn(isbn), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/purchaseBook", method = RequestMethod.POST)
    public ResponseEntity<BookingServiceSuccessResponse> buyBook(@RequestBody @Valid OrderBean orderBean) throws Exception {
        return new ResponseEntity<BookingServiceSuccessResponse>(bookService.buyBook(orderBean), HttpStatus.CREATED);

    }
}
