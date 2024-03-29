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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        // Write your code here
        String subString = "";
        boolean isValid = false;
        for (int i = 1; i <= s.length() / 2; i++) {
            subString = s.substring(0, i);
            //parse two string
            Long num = Long.parseLong(subString);
            String validString = subString;
            while (validString.length() < s.length()) {
                validString += Long.toString(++num);
            }
            if (validString.equals(s)) {
                isValid = true;
                break;
            }
        }
        //substring is yes or no
        System.out.println(isValid ? "YES " + subString : "NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
