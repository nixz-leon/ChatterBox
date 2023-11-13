package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

class UserProfileTest {

    @ParameterizedTest
    @MethodSource("nameFactory")
    void paramTestSetUserName(String userName) {
        assertEquals("John Doe", userName);
    }

    static Stream<Arguments> nameFactory()
    {
        return Stream.of(
          arguments("John Doe")
        );
    }

    @Test
    void testSetUserName() {
        String userName = "John Doe";
        String info = "Age 25, Likes Dogs";
        UserProfile userProfile = new UserProfile(userName, info);
        String newUserName = "Jane Doe";

        userProfile.setUserName(newUserName);

        assertEquals(newUserName, userProfile.getUserName());
    }

    @Test
    void testGetUserName() {
        String userName = "John Doe";
        String info = "Age 25, Likes Dogs";
        UserProfile userProfile = new UserProfile(userName, info);

        assertEquals(userName, userProfile.getUserName());
    }

    @Test
    void testSetInfo()
    {
        String userName = "John Doe";
        String info = "Age 25, Likes Dogs";
        UserProfile userProfile = new UserProfile(userName, info);
        String newInfo = "Age 23, Likes Cats";

        userProfile.setUserName(newInfo);

        assertEquals(newInfo, userProfile.getUserName());
    }

    @ParameterizedTest
    @MethodSource("infoFactory")
    void paramTestSetInfo(String info)
    {
        assertEquals("Age 25, Likes Dogs", info);
    }

    static Stream<Arguments> infoFactory()
    {
        return Stream.of(
                arguments("Age 25, Likes Dogs")
        );
    }

    @Test
    void testGetInfo() {
    }

    @Test
    void testAddProfile() throws IOException
    {
        String userName = "John Doe";
        String info = "Age 25, Likes Dogs";
        File file = new File(System.getProperty("user.home") + "/data.txt");

        UserProfile userProfile = new UserProfile(userName, info);
        userProfile.addProfile();

        assertTrue(file.exists());
        String fileContent = readFile(file);
        assertEquals(userName + ", " + info, fileContent);
    }

    private String readFile(File file) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    void testRemoveProfile() throws IOException
    {
        String userName = "John Doe";
        String info = "Age 25, Likes Dogs";
        String profileContent = userName + ", " + info;
        File file = new File(System.getProperty("user.home") + "/data.txt");

        if(!file.exists())
        {
            Files.createFile(file.toPath());
        }
        FileWriter writer = new FileWriter(file);
        writer.write(profileContent);
        writer.close();

        UserProfile userProfile = new UserProfile(userName, info);
        userProfile.removeProfile();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null)
        {
            if(line.equals(profileContent))
            {
                fail("Profile was not removed!!");
            }
        }
        reader.close();

        assertTrue(file.exists());
    }
}
