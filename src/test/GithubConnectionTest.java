package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.GithubConnection;
import main.NotAGithubUserException;

public class GithubConnectionTest {
	
	private static final String GITHUB_API_REPO = "https://api.github.com/repos/gmrodgers/WACC_compiler/languages";
    private static final String JSON_RESPONSE_STRING = 
    		"{\"Java\":101880,\"ANTLR\":4935,\"Ruby\":2778,\"Shell\":954,\"Makefile\":710}";
	
	@Test
	public void getResponseTest() throws NotAGithubUserException {
		assertEquals((new GithubConnection(GITHUB_API_REPO)).getResponse(), JSON_RESPONSE_STRING);
	}

}
