package com.sutek.blog.repository;

import com.sutek.blog.model.Post;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    @Query("SELECT * FROM POST WHERE author = :id")
    List<Post> findByAuthor(Integer id);

}
