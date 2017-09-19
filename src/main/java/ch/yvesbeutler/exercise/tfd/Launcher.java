package ch.yvesbeutler.exercise.tfd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yvesbeutler
 * Term Frequency Distribution (TFD)
 */
public class Launcher {

    public static void main(String[] args) {

        String path = "resources/shakespeare-hamlet.txt";

        try {

            // memory efficient way to read large content
            LineIterator iterator = FileUtils.lineIterator(new File(path), "UTF-8");

            try {

                List<SingleWord> results = new ArrayList<>();

                while (iterator.hasNext()) {
                    String line = iterator.nextLine();

                    // split each line at every unwanted char
                    String regex = "[^a-zA-Z0-9/']";
                    String[] words = line.split(regex);

                    for(String word : words) {
                        System.out.println(word);

                        if(results.contains(word)) {
                            // something like that
                            results.get(0).increase();
                        } else {
                            results.add(new SingleWord(word));
                        }
                    }

                    // create new array entry for every new word

                    // update array value by +1

                }
            } finally {
                LineIterator.closeQuietly(iterator);
            }

        } catch (IOException ioe) {
            System.out.println("Couldn't find file at: " + path);
            ioe.printStackTrace();
        }
    }
}
