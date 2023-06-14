/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.bannedwords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Jatin Wadhwani
 */
public class WordChecker {

    private static Map<String, String> bannedWords = new HashMap<>();
    private static Properties properties = new Properties();

    public static String isABannedWord(String word) {
        String originaldata = word;
        
        try {
            FileInputStream file = new FileInputStream("src/chitchat/bannedwords/bannedwords.properties");
            properties.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bannedWords = (Map) properties;

        // create a list of banned words from the map
        ArrayList<String> filters = new ArrayList<>(bannedWords.keySet());

        // iterate over all the possible pairs of banned words
        for (String filter : filters) {
            for (String filteredWord : filters) {
                // concatenate the pair of banned words
                String pair = filter + filteredWord;

                // replace any occurrence of the pair with asterisks
                if (word.contains(pair)) {
                    StringBuilder replacedString = new StringBuilder();
                    for (int k = 0; k < filter.length() + filteredWord.length(); k++) {
                        replacedString.append("*");
                    }
                    word = word.replaceAll(pair, replacedString.toString());
                }
            }
        }

        // iterate over the map of banned words and their replacements
        for (Map.Entry<String, String> wordToBeReplaced : bannedWords.entrySet()) {
            // replace any occurrence of the banned word with its replacement
            word = word.replaceAll("\\b" + wordToBeReplaced.getKey() + "\\b", wordToBeReplaced.getValue());
        }
        
        if(originaldata.equals(word)) {
            return null;
        }
        
        return word;
    }

}
