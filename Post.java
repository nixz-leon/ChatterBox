package org.example;

import java.util.Date;
import java.util.List;

public class Post
{
    // maximums for post length and username length
    int MAX_POST_LENGTH = 150;
    int MAX_USERNAME_LENGTH = 50;

    // get the unique identifier of the post
    String getId() { return getId(); }

    // get the content of the post
    String getContent() { return getContent(); }
    // set the content of the post
    void setContent() { }

    // get username of the post's author
    String getAuthor() { return getAuthor(); }

    // get the timestamp when the post was created
    Date getTimestamp() { return getTimestamp(); }

    // add a comment on the post
    void addComment(String comment) { }

    // get the comments on the post
    // List<String> getComments() { return getComments(); }

}
