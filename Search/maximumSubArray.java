import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maximumSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. LONG_INTEGER_ARRAY a
     * 2. LONG_INTEGER m
     */
    // public static long maxArr(List<Long> arr){
    // long max =0;
    // for(Long elm: arr){
    // if(elm >max){
    // max = elm;
    // }
    // }
    // return max;
    // }

    public static long maximumSum(List<Long> a, long m) {
        // Write your code here

        long max = 0;
        long prefix = 0;
        //TreeSet
        TreeSet<Long> sets = new TreeSet<Long>();
        sets.add(0L);

        for (int i = 0; i < a.size(); i++) {

            prefix = (prefix + a.get(i)) % m;
            max = Math.max(prefix, max);

            Long it = sets.higher(prefix);

            if (it != null) {
                max = Math.max(max, (prefix - it + m) % m);
            }
            sets.add(prefix);
        }
        System.out.println(sets);

        return max;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            long m = Long.parseLong(firstMultipleInput[1]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Long> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aTemp[i]);
                a.add(aItem);
            }

            long result = Result.maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
