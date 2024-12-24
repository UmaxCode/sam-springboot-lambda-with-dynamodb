package org.umaxcode.repository;

import org.umaxcode.domain.entity.Post;

import java.util.List;

public interface PostRepository {
    Post savePost(Post post);

    List<Post> getAllPost();

    Post getPostById(String postId);

    Post updatePost(String postId, Post post);

    void deletePost(String postId);

}
