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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY arr
     * 2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for (Integer elm : arr) {
            if (!map1.keySet().contains(elm)) {
                map1.put(elm, 1);
            } else {
                int val = map1.get(elm);
                val++;
                map1.put(elm, val);
            }
        }
        for (Integer elm : brr) {
            if (!map2.keySet().contains(elm)) {
                map2.put(elm, 1);
            } else {
                int val = map2.get(elm);
                val++;
                map2.put(elm, val);
            }
        }
        List<Integer> same = new ArrayList<Integer>();
        List<Integer> diff1 = new ArrayList<Integer>();
        List<Integer> diff2 = new ArrayList<Integer>();
        for (Integer elm : map1.keySet()) {
            if (map2.keySet().contains(elm)) {
                same.add(elm);
            }
        }
        for (Integer elm : map1.keySet()) {
            if (!same.contains(elm)) {
                diff1.add(elm);
            }
        }
        for (Integer elm : map2.keySet()) {
            if (!same.contains(elm)) {
                diff2.add(elm);
            }
        }
        for (Integer elm : same) {
            int val = Math.abs(map1.get(elm) - map2.get(elm));
            if (val != 0) {
                // for(int i =0; i< val;i++){
                // result.add(elm);
                // }
                result.add(elm);
            }

        }
        for (Integer elm : diff1) {
            int val = map1.get(elm);
            if (val != 0) {
                result.add(elm);
                // for(int i =0; i< val;i++){
                // result.add(elm);
                // }
            }

        }
        for (Integer elm : diff2) {
            int val = map2.get(elm);
            if (val != 0) {
                for (int i = 0; i < val; i++) {
                    result.add(elm);
                }
            }

        }
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(same);
        System.out.println(diff1);
        System.out.println(diff2);
        Collections.sort(result);
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
