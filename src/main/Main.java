package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please enter a user of github:");
		Scanner input = new Scanner(System.in);
		String user = input.nextLine();
		GithubUser githubUser = new GithubUser(user);
		input.close();
		Map<String, Integer> totals = calculateLanguageTotals(githubUser.getRepos());
		System.out.println(user + "'s favourite programming language is " + maxTotal(totals));
	}

	public static String maxTotal(Map<String, Integer> totals) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Map<String, Integer> calculateLanguageTotals(List<GithubRepo> repos) {
		// TODO Auto-generated method stub
		return null;
	}

}
