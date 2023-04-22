package com.pictet.technologies.opensource.reactive.r2dbc.todolist.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Person {

    @Id
    private Long id;

    @Version
    private Long version;

    @NotBlank
    @Size(max=100)
    private String firstName;

    @NotBlank
    @Size(max=100)
    private String lastName;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
