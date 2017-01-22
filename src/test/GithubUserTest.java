package test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import main.GithubRepo;
import main.GithubUser;
import main.NotAGithubUserException;

public class GithubUserTest {
	
    private static final String GITHUB_USER = "gmrodgers";
    private static final String[] GITHUB_REPOS = {
    		"Enigma_machine", "Sorting_comparisons", "WACC_compiler", "webapps_2016", "FavLanguageFinder"
    };
    private GithubUser user;
    private List<String> githubRepos;
    
    @Before
    public void setUp() {
    	user = new GithubUser(GITHUB_USER);
    	githubRepos = new LinkedList<String>(Arrays.asList(GITHUB_REPOS));
    }
    
	@Test
	public void getReposTest() throws NotAGithubUserException {
		List<GithubRepo> repos = user.getRepos();
		ListIterator<GithubRepo> lit = repos.listIterator();
		while (lit.hasNext()) {
			GithubRepo repo = (GithubRepo) lit.next();
			assertTrue(githubRepos.contains(repo.getReponame()));
		}
	}
	
	@Test
	public void getReposFailsAndThrowsExceptionTest() {
		boolean notAGithubUserExceptionThrown = false;
		try {
			new GithubUser(GITHUB_USER + "xxxxxxxxxxxx").getRepos();
		} catch (NotAGithubUserException e) {
			notAGithubUserExceptionThrown = true;
		}
		assertTrue(notAGithubUserExceptionThrown);
	}

}
