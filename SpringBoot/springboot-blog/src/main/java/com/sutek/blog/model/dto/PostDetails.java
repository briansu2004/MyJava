package com.sutek.blog.model.dto;

import com.sutek.blog.model.Author;
import com.sutek.blog.model.Post;

public record PostDetails(Post post, Author author) { }
