package com.springboot.compositekey.repository;

import com.springboot.compositekey.entity.Book;
import com.springboot.compositekey.entity.BookIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//spring annotation
@Repository
public interface BookRepository extends CrudRepository<Book, BookIdentity> {

    //spring jpa will automatically parse the method name
    //and create a query from it.
    Optional<Book> findByIdentityIsbnId(String isbnId);

    List<Book> findByIdentityId(int id);
}
