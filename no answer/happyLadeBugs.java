import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */
     private static final String YES = "YES";
    private static final String NO = "NO";
    private static final char UNDERSCORE = '_';
    private static final int NUMBER_OF_CHARACTERS = 26;
    private static final int INDEX_A = 65;
    
    public static String happyLadybugs(String board) {
        int numberOfEmptyCells = 0;
        //character frequency
        int[] characterFrequencies = new int[NUMBER_OF_CHARACTERS];
        
        /* Determine the frequencies */
        for (char currentCharacter : board.toCharArray()) {
            if (currentCharacter == UNDERSCORE) { // cell is empty - recheck
                numberOfEmptyCells++;
            } else { // cell contains a ladybug
                //check cell to contains a ladybug or not
                int characterIndex = currentCharacter - INDEX_A;
                characterFrequencies[characterIndex]++;
            }
        }
        
        /* If there is only a single colored ladybug, there is no chance made all ladybugs happy */
        for (int frequency : characterFrequencies) {
            //check if there is any character
            if (frequency == 1) {
                return NO;
            }
        }
        
        /* If there board consists of ladybugs all of them are happy -check */
        if (isAlreadyAllLadybugsHappy(board)) {
            return YES;
        }
        
        /* If there is no chance to make all ladybugs happy */
        if (numberOfEmptyCells == 0) {
            return NO;
        }
        
        return YES; // all ladybugs can be made happy
    }
    
    private static boolean isAlreadyAllLadybugsHappy(String board) {
        if (board.length() == 1) {
            return false;
        }
        
        for (int i = 1; i < board.length() - 1; i++) {
            if (board.charAt(i) != board.charAt(i - 1) && board.charAt(i) != board.charAt(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
