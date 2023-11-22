package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create New Profile.");
        System.out.println("\nInput Username: ");
        String name = scanner.nextLine();
        System.out.println("\nInput Bio: ");
        String bio = scanner.nextLine();

        UserProfile profile = new UserProfile(name, bio);

        System.out.println("\nCreate a new post: ");
        String userPost = scanner.nextLine();


        Post newPost = new Post(userPost, name);
        newPost.setId(name);
        newPost.setTimeStamp();
        System.out.println("\n");
        System.out.println(profile.getUserName() + " getUserName \n" + profile.getInfo() + " getInfo \n"
                + newPost.getAuthor() + " getAuthor \n" + newPost.getTimestamp() + " getTimeStamp \n" +
                 newPost.getId() + " getId \n" + newPost.getContent() + " getContent");
    }
}