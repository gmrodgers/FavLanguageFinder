package main;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GithubUser {

    private final String username;
    private List<GithubRepo> repos;
    private static String GITHUB_API = "https://api.github.com/users/";

    public GithubUser (String username) {
        this.username = username;
        this.repos = new LinkedList<>();
    }

    /* Give a user, get their repos */
    public List<GithubRepo> getRepos() throws NotAGithubUserException {
        GithubConnection connection = new GithubConnection(GITHUB_API + username + "/repos");
        JSONArray jsonArray = new JSONArray(connection.getResponse());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            JSONObject owner = json.getJSONObject("owner");
            repos.add(new GithubRepo(owner.getString("login"), json.getString("name")));
        }
        connection.closeConnection();
        return repos;
    }


}
