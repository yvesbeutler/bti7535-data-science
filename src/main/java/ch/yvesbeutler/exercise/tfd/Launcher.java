package ch.yvesbeutler.exercise.tfd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yvesbeutler
 * Term Frequency Distribution (TFD)
 * This application separates every single word from a given text and sorts the used
 * words in order of their number of appearances, starting with the most common word.
 */
public class Launcher {

    public static void main(String[] args) {

        String path = "resources/shakespeare-hamlet.txt";

        try {

            // memory efficient way to read large content
            LineIterator iterator = FileUtils.lineIterator(new File(path), "UTF-8");

            try {

                Map<String, Integer> results = new HashMap<>();

                while (iterator.hasNext()) {
                    String line = iterator.nextLine();

                    // split each line at every unwanted char
                    String regex = "[^a-zA-Z0-9/']";
                    String[] words = line.split(regex);

                    for(String word : words) {

                        // words must contain at least 1 char
                        if(word.length() > 0) {
                            if(results.containsKey(word)) {
                                // update amount
                                results.put(word, results.get(word) + 1);
                            } else {
                                // add new entry
                                results.put(word, 1);
                            }
                        }
                    }
                }

                // Sort the map with streams
                results.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .forEach(System.out::println);

            } finally {
                LineIterator.closeQuietly(iterator);
            }

        } catch (IOException ioe) {
            System.out.println("Couldn't find file at: " + path);
            ioe.printStackTrace();
        }
    }
}
