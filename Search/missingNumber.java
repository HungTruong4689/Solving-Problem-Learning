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
        //map value hashmap
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        // HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        //result list
        List<Integer> result = new ArrayList<Integer>();
        //hashSet sub
        HashSet<Integer> sub = new HashSet<Integer>();

        for (Integer elm : arr) {
            //map1 contains elm
            if (!map1.keySet().contains(elm)) {
                map1.put(elm, 1); //map contains
            } else {
                int val = map1.get(elm);
                val++;
                map1.put(elm, val);
            }
        }
        for (Integer elm : brr) { //for loop o n
            if (map1.keySet().contains(elm)) {
                //add elm of sub
                sub.add(elm);
                int val = map1.get(elm);
                val--;
                map1.put(elm, val);
            } else {

                map1.put(elm, 1);
            }
        }
        for (Integer elm : sub) {
            if (map1.get(elm) == 0) {
                map1.remove(elm);
            }
        }
        for (Integer elm : map1.keySet()) {
            result.add(elm);
        }

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
