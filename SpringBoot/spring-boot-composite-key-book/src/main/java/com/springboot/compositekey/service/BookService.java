package com.springboot.compositekey.service;

import com.springboot.compositekey.entity.Book;
import com.springboot.compositekey.entity.BookIdentity;
import com.springboot.compositekey.exception.EntityNotFound;
import com.springboot.compositekey.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//service class to call the dao class methods

//lombok annotation
@Slf4j
//spring annotation
@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public void saveAll(final List<Book> books) {
        repository.saveAll(books);
    }

    public boolean areDefaultBooksPresents() {
        log.info("Getting total books count");
        return repository.count() > 0;
    }

    public List<Book> getAll() {
        log.info("Getting all books");
        final Iterable<Book> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    //find a book using the composite key - id and isbn id
    public Book findByBookAndIsbnId(final int id, final String isbnId)
            throws EntityNotFound {
        log.info("Getting book with id = {} and isbn-id = {}", id, isbnId);
        final BookIdentity identity = new BookIdentity(id, isbnId);
        return repository.findById(identity).orElseThrow(EntityNotFound::new);
    }

    //find a book by isbn id
    public Book findByIdentityIsbnId(final String isbnId)
            throws EntityNotFound {
        log.info("Getting book with isbn id = {}", isbnId);
        return repository.findByIdentityIsbnId(isbnId).orElseThrow(EntityNotFound::new);
    }

    //find books by id
    public List<Book> findByIdentityId(final int id) {
        log.info("Getting all books with id = {}", id);
        return repository.findByIdentityId(id);
    }
}
