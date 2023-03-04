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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, List<List<Integer>>> sets = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < arr.size() - 1; i++) {
            int val = Math.abs(arr.get(i + 1) - arr.get(i));
            if (val < min) {
                min = val;
            }
            if (!sets.keySet().contains(val)) {
                List<List<Integer>> inner = new ArrayList<List<Integer>>();
                List<Integer> sub = new ArrayList<Integer>();
                sub.add(arr.get(i));
                sub.add(arr.get(i + 1));
                inner.add(sub);
                sets.put(val, inner);
            } else {
                List<List<Integer>> inner = sets.get(val);
                List<Integer> sub = new ArrayList<Integer>();
                sub.add(arr.get(i));
                sub.add(arr.get(i + 1));
                inner.add(sub);
                sets.put(val, inner);
            }
        }
        for (List<Integer> elm : sets.get(min)) {
            // System.out.println(elm);
            result.add(elm.get(0));
            result.add(elm.get(1));
        }
        Collections.sort(result);
        // System.out.println(sets.get(min));
        // System.out.println(sets);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
