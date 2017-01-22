package main;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GithubRepo {

    private final String owner;
    private final String repoName;
    private Map<String, Integer> languageCounts;
    private static String GITHUB_API = "https://api.github.com/repos/";

    public GithubRepo(String owner, String repoName) {
        this.owner = owner;
        this.repoName = repoName;
        this.languageCounts = new HashMap<>();
    }

    /* Get the language counts for user and a repo */
    public Map<String, Integer> getLanguageCounts() {
        GithubConnection connection = new GithubConnection(GITHUB_API + owner + "/" + repoName + "/languages");
        JSONObject json = new JSONObject();
        try {
            json = new JSONObject(connection.getResponse());
        } catch (NotAGithubUserException e) {
            // Not a github repo in this case
        } finally {
            connection.closeConnection();
        }
        for (Map.Entry<String, Object> e : json.toMap().entrySet()) {
            languageCounts.put((String) e.getKey(), (Integer) e.getValue());
        }
        return languageCounts;
    }

	public String getOwner() {
		return owner;
	}

	public String getReponame() {
		return repoName;
	}
}
