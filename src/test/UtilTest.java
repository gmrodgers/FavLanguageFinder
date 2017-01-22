package test;

import main.GithubRepo;
import main.Util;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {
	
	private Map<String, Integer> totals;
	private List<GithubRepo> repos;
	private static final GithubRepo[] GITHUB_REPOS = {
			new GithubRepo("gmrodgers", "Enigma_machine"),
			new GithubRepo("gmrodgers", "Sorting_comparisons")
	};
	
	@Before
	public void setUp() {
		totals = new HashMap<>();
		repos = new LinkedList<>(Arrays.asList(GITHUB_REPOS));
	}

	@Test
	public void maxTotalFindsCorrectLanguageTest() {
		totals.put("Java", 19);
		totals.put("Javascript", 20);
		totals.put("Haskell", 18);
		assertEquals(Util.maxTotal(totals), "Javascript");
	}
	
	@Test
	public void calculateLanguageTotalsTest() {
		Map<String, Integer> newTotals = Util.calculateLanguageTotals(repos);
		assertEquals((int) newTotals.get("C++"), 6271);
		assertEquals((int) newTotals.get("Makefile"), 334);
		assertEquals((int) newTotals.get("PureBasic"), 167);
		assertEquals((int) newTotals.get("Python"), 6793);
		assertEquals((int) newTotals.get("Jupyter Notebook"), 87690);
		
		
	}

}
