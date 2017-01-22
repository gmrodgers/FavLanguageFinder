package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GithubConnection {

    private final String url;
    private Scanner outputStream;

    public GithubConnection(String url) {
        this.url = url;
    }

    public String getResponse() throws NotAGithubUserException {
        try {
            URL userUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) userUrl.openConnection();
            connection.setRequestMethod("GET");
            outputStream = new Scanner(connection.getInputStream());
        } catch (FileNotFoundException e) {
            throw new NotAGithubUserException();
        } catch (IOException e) {
            System.err.println("Connection to input stream failed");
            e.printStackTrace();
        }
        return outputStream.nextLine();
    }

    public void closeConnection() {
        outputStream.close();
    }
}
