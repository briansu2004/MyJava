package com.springboot.compositekey.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//class contain more than 1 primary key columns.

//lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring jpa annotation
@Embeddable
public class BookIdentity implements Serializable {

    @Column(nullable = false)
    int id;
    @Column(name = "isbn_id", nullable = false)
    String isbnId;
}
