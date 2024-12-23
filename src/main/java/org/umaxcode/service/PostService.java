package org.umaxcode.service;

import org.umaxcode.domain.entity.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    List<Post> getAllPost();

    Post getPostById(int id);

    void deletePostById(int id);
}
