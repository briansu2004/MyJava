package com.springboot.compositekey.bootstrap;

import com.github.javafaker.Faker;
import com.springboot.compositekey.entity.Book;
import com.springboot.compositekey.entity.BookIdentity;
import com.springboot.compositekey.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//boostrapped at the startup to automatically create users in the db

//lombok annotation
@Slf4j
//spring annotation
@Component
public class DefaultBooksLoader implements CommandLineRunner {

    @Autowired
    BookService service;
    @Autowired
    Faker faker;

    @Override
    public void run(String... args) {
        loadBooks();
    }

    private void loadBooks() {
        if (service.areDefaultBooksPresents()) {
            log.info("Default books are already present");
        } else {
            final List<Book> books = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                books.add(create());
            }

            log.info("Saving default books in db");
            service.saveAll(books);
        }
    }

    private Book create() {
        final int randomNumber = faker.number().numberBetween(50, 100);
        //with composite key you'll have to manually create the primary keys
        //combination.
        final BookIdentity identity = BookIdentity.builder()
                .id(faker.number().randomDigitNotZero())
                .isbnId(UUID.randomUUID().toString())
                .build();
        return Book.builder()
                .title(faker.book().title())
                .author(faker.book().author())
                .publisher(faker.book().publisher())
                .genre(faker.book().genre())
                .quantity(randomNumber)
                .publishedOn(LocalDateTime.now().minusHours(randomNumber)
                        .minus(Period.ofWeeks(randomNumber)))
                .identity(identity)
                .build();
    }
}
