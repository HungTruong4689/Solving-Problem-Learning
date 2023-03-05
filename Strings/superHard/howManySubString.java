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
     * Complete the 'countSubstrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. 2D_INTEGER_ARRAY queries
     */
    public static HashSet<String> findSubSet(String s) {
        HashSet<String> sets = new HashSet<String>();
        int distance = 1;
        while (distance <= s.length()) {
            for (int i = 0; i + distance <= s.length(); i++) {
                String val = s.substring(i, i + distance);
                sets.add(val);
            }
            distance++;
        }
        return sets;
    }

    public static List<Integer> countSubstrings(String s, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();

        for (List<Integer> elm : queries) {
            String newS = s.substring(elm.get(0), elm.get(1) + 1);
            int val = findSubSet(newS).size();
            System.out.println(findSubSet(newS));
            result.add(val);
        }
        // System.out.println(findSubSet(s));

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.countSubstrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
