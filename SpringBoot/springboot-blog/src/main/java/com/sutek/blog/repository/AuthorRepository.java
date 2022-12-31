package com.sutek.blog.repository;

import com.sutek.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    Author findByUsername(String username);
}
