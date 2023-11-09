package org.example;

import org.example.Post;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {
    private List<Post> posts;

    public PostStorage() {
        this.posts = new ArrayList<>();
    }

    public void appendPost(Post post) {
        posts.add(post);
    }

    public List<Post> getAllPosts() {
        return posts;
    }
}