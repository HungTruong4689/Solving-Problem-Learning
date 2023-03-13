
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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
        // Write your code here
        int num = 0;
        String rock = Collections.min(arr);
        int x = arr.indexOf(rock);
        HashSet<Character> mss = new HashSet<Character>();
        rock.chars().forEach(m -> mss.add((char) m));
        int n = arr.size();
        for (Character min : mss) {
            int mc = 1;
            for (int i = 0; i < n; i++) {
                if (i != x && arr.get(i).contains(String.valueOf(min))) {
                    mc++;
                }
            }
            if (mc >= n)
                num++;
        }

        return num;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
