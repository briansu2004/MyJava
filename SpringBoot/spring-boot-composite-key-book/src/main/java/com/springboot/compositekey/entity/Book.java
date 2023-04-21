package com.springboot.compositekey.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

//entity class to ber persisted in the db

//spring jpa annotations
@Entity
@Table(name = "book")
//lombok annotations
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//spring annotation
@Component
public class Book {

    //composite primary key
    @EmbeddedId
    BookIdentity identity;
    String title;
    String author;
    String genre;
    String publisher;
    int quantity;
    @Column(name = "published_on")
    LocalDateTime publishedOn;
}
