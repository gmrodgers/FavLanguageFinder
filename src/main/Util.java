package main;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Util {
	
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
