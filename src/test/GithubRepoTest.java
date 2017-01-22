package test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.GithubRepo;

public class GithubRepoTest {
	
    private static final String GITHUB_OWNER = "gmrodgers";
    private static final String GITHUB_REPO = "Enigma_machine";
    private GithubRepo repo;
    
    @Before
    public void setUp() {
    	repo = new GithubRepo(GITHUB_OWNER, GITHUB_REPO);
    }
    
	@Test
	public void getLanguageCountsTest() {
		Map<String, Integer> counts = repo.getLanguageCounts();
		assertEquals((int) counts.get("C++"), 6271);
		assertEquals((int) counts.get("Makefile"), 334);
		assertEquals((int) counts.get("PureBasic"), 167);
		assertEquals((int) counts.get("Python"), 6793);
	}
	
	@Test
	public void getReponameTest() {
		assertEquals(GITHUB_REPO, repo.getReponame());
	}
	
	@Test
	public void getOwnerTest() {
		assertEquals(GITHUB_OWNER, repo.getOwner());
	}

}
