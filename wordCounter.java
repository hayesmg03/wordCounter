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
                    System.out.println(word);
                }
                lineNumb++;
            }
            reader.close();
        } catch (FileNotFoundException err) {
            System.out.println("File Not Found.");
            System.out.println(err);
        }
    }

}