package org.example;

import org.example.Post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

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
        File csvFile = new File("src/main/resources/"+filename);
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

    static int  splitter(String text, char sep, String arr[], int size){
        int counter = 0;
        String temp = "";
        int textLength = text.length();
        if(textLength == 0){
            //edge case
            return 0;
        }
        for(int i =0; i < textLength; i++){
            if(text.charAt(i) == sep){
                // condition to let me still assign the last section
                if(counter < (size-1)){
                    // resets temp based on whether it see identifier
                    arr[counter] = temp;
                    counter++;
                    temp = "";
                }else{
                    // if it goes outof bounds it still assigns the temp to the last slot
                    arr[counter] = temp;
                    return -1;
                }
            }else{
                // adds the characters to temp
                temp += text.charAt(i);
            }
        }
        //makes sure last section gets assigned
        arr[counter] = temp;
        return counter + 1;
    }

    public void loadPosts(String filename) throws FileNotFoundException, ParseException {
        File csvFile = new File("src/main/resources/"+filename);
        Scanner line = new Scanner(csvFile);
        while (line.hasNextLine()){
            String data = line.nextLine();
            String split_up[] = new String[4];
            splitter(data,',',split_up, 4);
            Post newPost = new Post(split_up[0],split_up[2]);
            newPost.setId(split_up[1]);  // need either that setter method or a constructor
            //Date date = new SimpleDateFormat("MM/dd/yyyy").parse(split_up[3]);
            //newPost.setTimeStamp(date);
        }
    }

}