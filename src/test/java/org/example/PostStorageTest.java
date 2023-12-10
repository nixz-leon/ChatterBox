package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.SplittableRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PostStorageTest {

    @Test
    void testAppendPost() {
        PostStorage storage = new PostStorage();
        Post post = new Post("Test Content", "Author");

        storage.appendPost(post);

        assertThat(storage.getAllPosts().size(), is(1));
        assertThat(storage.getAllPosts().get(0), is(post));
    }

    @Test
    void testGetAllPosts() {
    }

    @Test
    void testStorePosts() throws IOException {
        PostStorage storage = new PostStorage();
        Post post1 = new Post("Testing Content 1", "Bill");
        Post post2 = new Post("Second Test Content", "Jake");
        storage.appendPost(post1);
        storage.appendPost(post2);

        String filename = "test_post.csv";
        storage.storePosts(filename);


        File csvFile = new File("src/main/files2/"+filename);
        assertThat(csvFile.exists(), is(true));

        String content = "";
        try(Scanner scanner = new Scanner(csvFile))
        {
            while(scanner.hasNextLine())
            {
                content += scanner.nextLine() + "\n";
            }
        }

        assertThat(content, containsString("Testing Content 1"));
        assertThat(content, containsString("Second Test Content"));

    }

    @Test
    void testStoreInvPost() {
    }

    @Test
    void testSplitter() {
    }

    @Test
    void testLoadPosts() throws FileNotFoundException, ParseException {
        PostStorage storage = new PostStorage();
        String filename = "test_posts.csv";

        // Create a test file with data

        File csvFile = new File("src/main/files2/"+filename);
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write("Test content 1,ID1,Author 1,2023-10-26\n");
            writer.write("Test content 2,ID2,Author 2,2023-10-27\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        storage.loadPosts(filename);

        assertThat(storage.getAllPosts().size(), is(2));

        Post post1 = storage.getAllPosts().get(0);
        assertThat(post1.getContent(), is("Test content 1"));
        assertThat(post1.getAuthor(), is("Author 1"));

        Post post2 = storage.getAllPosts().get(1);
        assertThat(post2.getContent(), is("Test content 2"));
        assertThat(post2.getAuthor(), is("Author 2"));
    }
}