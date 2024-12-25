package org.umaxcode.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.umaxcode.domain.entity.Post;
import org.umaxcode.exception.ServiceException;

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
        Post post = dynamoDBMapper.load(Post.class, postId);
        if (post != null) {
            return post;
        }

        throw new ServiceException("Post with id " + postId + " not found");
    }

    @Override
    public Post updatePost(String postId, Post post) {
        dynamoDBMapper.save(post, new DynamoDBSaveExpression()
                .withExpectedEntry("id", new ExpectedAttributeValue(
                        new AttributeValue(postId)
                )));
        return null;
    }

    @Override
    public void deletePost(String postId) {
        Post post = getPostById(postId);
        dynamoDBMapper.delete(post);
    }
}
