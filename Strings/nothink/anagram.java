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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        int[] arr = new int[26];

        if (s.length() % 2 == 1)
            return -1;

            //input the value to the array
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            // System.out.println(i + " " + j);
            arr[s.charAt(i) - 'a']++;
            arr[s.charAt(j) - 'a']--;
        }

        int count = 0;
        // add the difference
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
            //count the same value
            if (arr[i] < 0)
                count += Math.abs(arr[i]);
        }

        //count the similar value
        System.out.println(" End : " + count);
        return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
