package org.umaxcode.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.umaxcode.domain.entity.Post;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Override
    public Post savePost(Post post) {
        dynamoDBMapper.save(post);
        return post;
    }

    @Override
    public List<Post> getAllPost() {
        return dynamoDBMapper.scan(Post.class, new DynamoDBScanExpression());
    }

    @Override
    public Post getPostById(String postId) {
        return dynamoDBMapper.load(Post.class, postId);
    }

    @Override
    public Post updatePost(String postId, Post post) {

        Post post1 = getPostById(postId);
        post1.setTitle(post.getTitle() != null ? post.getTitle() : post1.getTitle());
        post1.setContent(post.getContent() != null ? post.getContent() : post1.getContent());
        dynamoDBMapper.save(post1);
        return null;
    }

    @Override
    public void deletePost(String postId) {
       Post post = getPostById(postId);
       dynamoDBMapper.delete(post);
    }
}
