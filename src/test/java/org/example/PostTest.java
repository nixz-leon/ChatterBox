package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PostTest {

    @Test
    void testSetId() {
        Post post = new Post("Test content", "", "", "Bobby");
        assertNotEquals("Bobby", post.getId());
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Bobby, Bobby57813",
                    "Holly, Holly57813",
                    "Mack, Mack57813"
            }
    )
    void paramTestSetId(String author, String expectedId) {

        Post post = new Post("Test content", "", "", author);
        post.setId(author);
        System.out.println("Actual: " + post.getId() + "\n" + "Expected: " + expectedId + "\n");
        assertNotEquals(expectedId, post.getId());

    }

    @Test
    void getId() {
        Post post = new Post("Test content", "", "", "Bobby");
        post.setId(post.getAuthor());
        System.out.println(post.getId() + " Hello");
    }

    @ParameterizedTest
    @MethodSource("contentFactory")
    void paramTestSetContent(String content) {
        Post post = new Post("", "", "", "Bobby");
        post.setContent(content);

        String[] words = content.trim().split("\\s+");
        int wordCount = words.length;

        System.out.println(wordCount);
        assertEquals(wordCount < post.MAX_POST_LENGTH, true);
    }

    static Stream<Arguments> contentFactory()
    {
        return Stream.of(
                arguments("The word cloud: https://en.wikipedia.org/wiki/Word_cloud is a visualization technique for representing text data. " +
                        "It is often used to visualize the relative importance of words in a document or corpus. " +
                        "The words in the word cloud are displayed in different sizes, with the most important words appearing larger. Word clouds can be created using a variety of software programs, including many free and open-source options." +
                        "\n\nWord clouds are often used to visualize the content of a single document, but they can also be used to visualize the content of a corpus of documents. " +
                        "For example, a word cloud could be used to visualize the most common words in a collection of news articles or blog posts."),

                arguments("The word cloud: https://en.wikipedia.org/wiki/Word_cloud is a visualization technique for representing text data. It is often used to visualize the relative importance of words in a document or corpus. The words in the word cloud are displayed in different sizes, with the most important words appearing larger. Word clouds can be created using a variety of software programs, including many free and open-source options.\n" +
                        "Word clouds are often used to visualize the content of a single document, but they can also be used to visualize the content of a corpus of documents. For example, a word cloud could be used to visualize the most common words in a collection of news articles or blog posts.\n" +
                        "Word clouds can be a useful tool for exploring text data and identifying key themes and topics. However, it is important to note that word clouds have some limitations. For example, they can be sensitive to stop words and can be difficult to interpret if the text is very long or complex.\n" +
                        "Overall, word clouds are a valuable tool for visualizing text data. They can be used to identify key themes and topics, and they can be a fun and engaging way to explore text data.\n")
        );
    }

    @Test
    void getContent() {
        String content = "The word cloud: https://en.wikipedia.org/wiki/Word_cloud is a visualization technique for representing text data. " +
                "It is often used to visualize the relative importance of words in a document or corpus. " +
                "The words in the word cloud are displayed in different sizes, with the most important words appearing larger. Word clouds can be created using a variety of software programs, including many free and open-source options." +
                "\n\nWord clouds are often used to visualize the content of a single document, but they can also be used to visualize the content of a corpus of documents. " +
                "For example, a word cloud could be used to visualize the most common words in a collection of news articles or blog posts.";

        Post post = new Post(content, "", "", "Bobby");
        System.out.println(post.getContent());
        assertEquals(content, post.getContent());
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Jones, Jones",
                    "April, April",
                    "Mary, Jones",
            }
    )
    void paramTestSetAuthor(String author, String expectedAuthor) {
        Post post = new Post("Test content", "", "", author);
        post.setAuthor(author);
        System.out.println("Actual: " + post.getAuthor() + "\n" + "Expected: " + expectedAuthor + "\n");
        assertEquals(expectedAuthor, post.getAuthor());
    }

    @Test
    void getAuthor() {
        String author = "Bobby";
        Post post = new Post("", "", "", author);
        System.out.println(post.getAuthor());
        assertEquals(author, post.getAuthor());
    }

    @Test
    void setTimeStamp() {
        Post post = new Post("", "", "", "Bobby");
        post.setTimeStamp();
        String timeStamp = post.getTimestamp();

        System.out.println(timeStamp);

        assertNotNull(timeStamp);
        assertFalse(timeStamp.isEmpty());
    }

    @Test
    void getTimestamp() {
        Post post = new Post("", "", "", "Bobby");
        post.setTimeStamp();
        String timeStamp = post.getTimestamp();

        System.out.println(timeStamp);
        assertEquals(timeStamp, post.getTimestamp());
    }

    @Test
    void addComment() {
    }
}