package org.umaxcode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.umaxcode.domain.entity.Post;
import org.umaxcode.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.savePost(post);
    }

    @Override
    public List<Post> getAllPost() {

        return postRepository.getAllPost();
    }


    @Override
    public Post getPostById(String id) {

        return postRepository.getPostById(id);
    }

    @Override
    public Post updatePostById(String id, Post post) {

        return postRepository.updatePost(id, post);
    }

    @Override
    public void deletePostById(String id) {

        postRepository.deletePost(id);
    }
}
