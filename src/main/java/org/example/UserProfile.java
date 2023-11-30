package org.example;
import java.io.*;

public class UserProfile {
    private String userName; // user name

    private String info;  // not sure what info yet

    public UserProfile(String userName, String info)
    {
        this.userName = userName; // changed from userName = userName to using this.userName
        this.info = info;
    } // end constructor


    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }

    public void addProfile()
    {
        try
        {
            //Create new file
            File file = new File(System.getProperty("user.home") + "/data.txt");
            FileWriter writer = new FileWriter(file);
            String content = getUserName() + ", " + getInfo();

            //write to file if content is not null
            try
            {
                if(content != null)
                {
                    writer.write(content);
                }
            }
            finally
            {
                writer.close();
            }
            System.out.println("Print Success from file in: " + file.getPath());
        } catch (IOException e)
        {
            System.err.println("Error writing profile" + e.getMessage());
        }
    }

    public void removeProfile()
    {
        try
        {
            //Read the current content in the file
            File file = new File(System.getProperty("src/main/files") + "/data.txt");
            StringBuilder fileContent = new StringBuilder();
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))  //BufferedReader is an optimized way to read files.
            {
                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    fileContent.append(line).append("\n");
                }
            }

            //identify profile to remove
            String userName = getUserName();
            String profileToRemove = userName + ", " + getInfo();

            //Rewrite file without removed profile
            String updatedContent = fileContent.toString().replace(profileToRemove, "");
            FileWriter writer = new FileWriter(file);
            writer.write(updatedContent);
            writer.close();

            System.out.println("Profile Removed!! from file in: " + file.getPath());
        }
        catch (IOException e)
        {
            System.err.println("Error removing profile: " + e.getMessage());
        }

    }

}
