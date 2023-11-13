package org.example;

import java.time.Instant;
import java.util.Random;

public class Post
{
    // maximums for post length and username length
    final int MAX_POST_LENGTH = 150; // set to final since they do not change
    final int MAX_USERNAME_LENGTH = 50;

    private String content;
    private String id;
    private String author;
    private String formattedTimestamp;
    private String comment;

    public Post(String content, String id, String formattedTimestamp, String author)
    {
        this.content = content;
        this.id = id;
        this.formattedTimestamp = formattedTimestamp;
        this.author = author;
    }
    public void setId(String author)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        this.id = author + randomNumber;
    }


    // get the unique identifier of the post
    String getId() { return id; }

    // set the content of the post
    public void setContent(String content)
    {
        String[] words = content.trim().split("\\s+");
        int wordCount = words.length;

        if(wordCount > MAX_POST_LENGTH)
        {
            System.out.println("Post too long!");
        }
        else
        {
            this.content = content;
        }

    }

    // get the content of the post
    String getContent() { return content; }

    public void setAuthor(String author)
    {
        if(author.length() <= MAX_USERNAME_LENGTH)
        {
            this.author = author;
        }
        else
        {
            this.author = author.substring(0, MAX_USERNAME_LENGTH - 1) + "...";
        }
    }

    // get username of the post's author
    String getAuthor() { return author; }

    public void setTimeStamp()
    {
        Instant timeStamp = Instant.now();
        formattedTimestamp = timeStamp.toString();
    }

    // get the timestamp when the post was created
    public String getTimestamp() { return formattedTimestamp; }

    // add a comment on the post
    public void addComment()
    {
        this.comment = comment;
    }

    // get the comments on the post
    // List<String> getComments() { return getComments(); }

}
