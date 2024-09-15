import java.util.TreeSet;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class wordCounter {
    public static void main(String[] args) {
        try {
            File inputFile = new File("alice.txt");
            Scanner reader = new Scanner(inputFile);
            int lineNumb = 0;
            TreeMap<String, Integer> map = new TreeMap<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                ArrayList<String> lineArray = new ArrayList<>();
                String[] badArray = line.split("[ \',-:().?!]");
                for (String word : badArray) {
                    if (word != "") {
                        lineArray.add(word);
                    }
                }
                for (String word : lineArray) {
                    if (map.get(word.toLowerCase()) == null) {
                        map.put(word.toLowerCase(), 1);
                    } else {
                        map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
                    }
                }
                lineNumb++;
            }
            System.err.println(map);
            reader.close();
        } catch (FileNotFoundException err) {
            System.out.println("File Not Found.");
            System.out.println(err);
        }
    }

}