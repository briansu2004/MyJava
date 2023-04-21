package com.springboot.compositekey.controller;

import com.springboot.compositekey.entity.Book;
import com.springboot.compositekey.exception.EntityNotFound;
import com.springboot.compositekey.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//spring annotations
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService service;

    //get all books
    //URL - http://localhost:9800/api/books
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return service.getAll();
    }

    //get book my composite key
    //URL - http://localhost:9800/api/book-by-composite-key?id=1&isbn-id=56d015bc-2b6f-4de0-a0a7-23cf1cda80f0
    @GetMapping("/book-by-composite-key")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookByCompositeKey(@RequestParam(name = "id") final int id,
                                      @RequestParam(name = "isbn-id") final String isbnId)
            throws EntityNotFound {
        return service.findByBookAndIsbnId(id, isbnId);
    }

    //find all books by isbn id
    //URL - http://localhost:9800/api/book-by-isbn-id?isbn-id=56d015bc-2b6f-4de0-a0a7-23cf1cda80f0
    @GetMapping("/book-by-isbn-id")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookByIsbnId(@RequestParam(name = "isbn-id") final String isbnId)
            throws EntityNotFound {
        return service.findByIdentityIsbnId(isbnId);
    }

    //find all books by id
    //URL - http://localhost:9800/api/books-by-id?id=1
    @GetMapping("/books-by-id")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksById(@RequestParam(name = "id") final int id) {
        return service.findByIdentityId(id);
    }
}
