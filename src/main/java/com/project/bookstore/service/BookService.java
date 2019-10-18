package com.project.bookstore.service;

import com.mongodb.client.result.UpdateResult;
import com.project.bookstore.Exception.BookSoldOutException;
import com.project.bookstore.Model.BookResponseBean;
import com.project.bookstore.Model.BookingServiceSuccessResponse;
import com.project.bookstore.Utils.Constants;
import com.project.bookstore.domain.BookBean;
import com.project.bookstore.domain.OrderBean;
import com.project.bookstore.entity.BookEntity;
import com.project.bookstore.mongo.BookRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Optional;

@Component
public class BookService {


    private final BookRepository bookRepository;

    private final MongoOperations mongoOperations;

    @Inject
    public BookService(BookRepository bookRepositoryImpl, MongoOperations mongoOperations) {
        this.bookRepository = bookRepositoryImpl;
        this.mongoOperations = mongoOperations;
    }

    public BookResponseBean addBookToStore(BookBean bookBean) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookBean.getAuthor());
        bookEntity.setIsbn(bookBean.getIsbn());
        bookEntity.setTitle(bookBean.getTitle());
        bookEntity.setPublisher(bookBean.getPublisher());
        bookEntity = mongoOperations.save(bookEntity);
        return new BookResponseBean(bookEntity.getId());
    }

    public BookResponseBean getBookByIsbn(String isbn) {
        Criteria criteria = Criteria.where("isbn").is(isbn);
        BookEntity bookEntity = mongoOperations.findOne(Query.query(criteria), BookEntity.class);
        return convertEntity(bookEntity);
    }

    public BookResponseBean getBookByTitle(String isbn) {
        Optional<BookEntity> bookEntity = bookRepository.findByTitle(isbn);
        return convertEntity(bookEntity.orElse(null));

    }

    public BookResponseBean getBookByAuthor(String isbn) {
        Optional<BookEntity> bookEntity = bookRepository.findByAuthor(isbn);
        return convertEntity(bookEntity.orElse(null));
    }

    public BookingServiceSuccessResponse buyBook(OrderBean orderBean) {
        UpdateResult result = mongoOperations.updateFirst(new Query(Criteria.where("isbn").is(orderBean.getBook().getIsbn()).and("stock").gt(0)),
                new Update().inc("stock", 1), BookEntity.class);

        if (result.getModifiedCount() != 1) {
            throw new BookSoldOutException(orderBean.getBook());
        }

        return new BookingServiceSuccessResponse(Constants.PURCHASE_SUCCESS);
    }

    private BookResponseBean convertEntity(BookEntity bookEntity) {
        BookBean bookBean = new BookBean();
        bookBean.setAuthor(bookEntity.getAuthor());
        bookBean.setPublisher(bookEntity.getPublisher());
        bookBean.setTitle(bookEntity.getTitle());
        bookBean.setIsbn(bookEntity.getIsbn());
        bookBean.setPrice(bookEntity.getPrice());
        return new BookResponseBean(bookEntity.getId(), bookBean);
    }
}
