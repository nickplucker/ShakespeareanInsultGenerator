import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class InsultGenerator {
    public static void main(String[] args) {
        ArrayList<String> column1 = new ArrayList<String>();
        ArrayList<String> column2 = new ArrayList<String>();
        ArrayList<String> column3 = new ArrayList<String>();

        // Put data from file into array
        try {
            column1 = readLines("column1.txt");
            column2 = readLines("column2.txt");
            column3 = readLines("column3.txt");
        } catch (Exception IOException) {
            System.out.println("IOException");
        }

        String result1 = column1.get(generateRandNum(1, column1.size()) - 1);
        String result2 = column2.get(generateRandNum(1, column2.size()) - 1);
        String result3 = column3.get(generateRandNum(1, column3.size()) - 1);

        printInsult(result1, result2, result3);
    }

    /**
     * @param result1
     * @param result2
     * @param result3
     */
    public static void printInsult(String result1, String result2, String result3) {
        System.out.println("Thou " + result1 + " " + result2 + " " + result3 + ".");
    }


    /**
     * @param min - lower limit of range
     * @param max - upper limit of range
     * @return
     */
    public static int generateRandNum(int min, int max) {
        Random rand = new Random();

        int  n = rand.nextInt(max) + min;

        return n;
    }

    /**
     * @param filename in the form "filename.txt"
     * @return ArrayList of strings
     * @throws IOException
     */
    public static ArrayList<String> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        bufferedReader.close();

        return lines;
    }

}
