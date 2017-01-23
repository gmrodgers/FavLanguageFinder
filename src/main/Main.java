package main;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("Please enter a user of github:");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();
        GithubUser githubUser = new GithubUser(user);
        input.close();
        try {
            Map<String, Integer> totals = Util.calculateLanguageTotals(githubUser.getRepos());
            System.out.println(user + "'s favourite programming language is " + Util.maxTotal(totals));
        } catch (NotAGithubUserException e) {
            System.out.println("Github user \"" + user + "\" does not exist");
        }
    }

}
