package org.umaxcode.service;

import org.springframework.stereotype.Service;
import org.umaxcode.domain.entity.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> posts;

    public PostServiceImpl() {
        posts = new ArrayList<>();
    }

    @Override
    public Post create(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        return posts.stream().filter(
                post -> post.getId() == id
        ).findFirst().orElse(null);
    }

    @Override
    public void deletePostById(int id) {
        posts.removeIf(post -> post.getId() == id);
    }
}
