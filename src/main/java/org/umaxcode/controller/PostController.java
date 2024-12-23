package org.umaxcode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.umaxcode.domain.entity.Post;
import org.umaxcode.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable int id) {
        postService.deletePostById(id);
    }
}
