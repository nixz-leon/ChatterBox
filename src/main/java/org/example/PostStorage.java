package org.example;

import org.example.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;

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

    public void storePosts(String filename) throws IOException {
        File csvFile = new File(filename);
        FileWriter filewriter = new FileWriter(csvFile);
        for (Post post : posts) {
            String postInfo = post.getContent();
            String postId = post.getId();
            String postAuthor = post.getAuthor();
            String postTimestamp = post.getTimestamp().toString();
            String line = postInfo + ',' + postId + ',' + postAuthor +','+postTimestamp+"\n";
            filewriter.write(line);
        }
        filewriter.close();
    }

    public void loadPosts(String filename){

    }
}