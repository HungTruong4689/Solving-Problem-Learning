package easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import Result;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        HashSet<Integer> map = new HashSet<Integer>();
        int i, j, curr;
        i = 0;

        //convert string to number
        while (i < s.length()) {
            j = i;
            curr = 0;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                curr += s.charAt(j++) - 'a' + 1;
                map.add(curr);
            }
            i = j;
        }
        // System.out.println(num);
        // System.out.println(sub);
        // System.out.println(sum);
        //watch the value if it contains value
        for (Integer elm : queries) {
            if (map.contains(elm)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
