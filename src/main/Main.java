package main;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
            Map<String, Integer> totals = calculateLanguageTotals(githubUser.getRepos());
            System.out.println(user + "'s favourite programming language is " + maxTotal(totals));
        } catch (NotAGithubUserException e) {
            System.out.println("Github user \"" + user + "\" does not exist");
        }
    }

    /* Finds max number of lines language, returns that language name */
    public static String maxTotal(Map<String, Integer> totals) {
        String maxName = "";
        int max = 0;
        for (String lang : totals.keySet()) {
            if (totals.get(lang) > max) {
                maxName = lang;
                max = totals.get(lang);
            }
        }
        return maxName;
    }

    /* Give a user and their repos, get the line counts of each language used by that user */
    public static Map<String, Integer> calculateLanguageTotals(List<GithubRepo> repos) {
        Map<String, Integer> languagesTotal = new HashMap<>();
        for (ListIterator<GithubRepo> lit = repos.listIterator(); lit.hasNext(); ) {
            Map<String, Integer> languagesCounts = lit.next().getLanguageCounts();
            for (String name : languagesCounts.keySet()) {
                int languageCount = languagesCounts.get(name);
                if (languagesTotal.containsKey(name)) {
                    languagesTotal.put(name, languagesTotal.get(name) + languageCount);
                } else {
                    languagesTotal.put(name, languageCount);
                }
            }
        }
        return languagesTotal;
    }

}
