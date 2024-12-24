package org.umaxcode.service;

import org.umaxcode.domain.entity.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    List<Post> getAllPost();

    Post getPostById(String  id);

    Post updatePostById(String id, Post post);

    void deletePostById(String id);
}
