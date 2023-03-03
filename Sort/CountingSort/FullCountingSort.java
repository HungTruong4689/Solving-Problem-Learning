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
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        HashMap<Integer, String> sets = new HashMap<Integer, String>();
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            int val = Integer.parseInt(arr.get(i).get(0));
            if (val >= max) {
                max = val;
            }
        }

        for (int i = 0; i < max + 1; i++) {
            // List<String> sub = new ArrayList<String>();
            sets.put(i, "");
        }

        for (int i = 0; i < arr.size(); i++) {

            if (i < arr.size() / 2) {
                arr.get(i).set(1, "-");
            }
            int num = Integer.parseInt(arr.get(i).get(0));
            String sub = sets.get(num);
            sub += arr.get(i).get(1) + " ";
            sets.put(num, sub);

        }

        // String count ="";
        // for(List<String> elm: sets.values()){
        // for(String val: elm){
        // count += val + " ";
        // }
        // }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < max + 1; i++) {
            String values = sets.get(i);

            sb.append(values);

        }
        // System.out.println(sets);
        System.out.println(sb);

        // System.out.println(count);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
