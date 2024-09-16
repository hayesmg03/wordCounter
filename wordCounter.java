import java.util.Map;
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
            int lineNumb = 1;
            TreeMap<String, TreeSet<Integer>> map = new TreeMap<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                ArrayList<String> lineArray = new ArrayList<>();
                String[] badArray = line.split("[ \',:().?!]");
                for (String word : badArray) {
                    if (word != "") {
                        lineArray.add(word);
                    }
                }
                for (String word : lineArray) {
                    if (map.get(word) == null) {
                        TreeSet<Integer> intSet = new TreeSet<>();
                        intSet.add(lineNumb);
                        map.put(word.toLowerCase(), intSet);
                    } else {
                        TreeSet<Integer> temp = map.get(word);
                        temp.add(lineNumb);
                        map.put(word, temp);
                    }
                }
                lineNumb++;
            }
            System.err.printf("%-15s%-15s%s", "word", "count", "line number\n");
            System.err.println("-------------------------------------------------");
            for (String key : map.keySet()) {
                System.err.printf("%-15s%-15d%-15s\n", key, map.get(key).size(), map.get(key));
            }
            reader.close();
        } catch (FileNotFoundException err) {
            System.out.println("File Not Found.");
            System.out.println(err);
        }
    }

}