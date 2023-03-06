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
    public static long maxArr(List<Long> arr) {
        long max = 0;
        for (Long elm : arr) {
            if (elm > max) {
                max = elm;
            }
        }
        return max;
    }

    public static long maximumSum(List<Long> a, long m) {
        // Write your code here

        // List<Long> list = new ArrayList<Long>();
        // long localMax=0; long max =0;
        // long sum =0;
        // for(int i =0; i < a.size();i++){
        // // localMax = a.get(i) % m;
        // // if(localMax >= max){
        // // max = localMax;
        // // }
        // // long sum=a.get(i);
        // sum = a.get(i);
        // localMax = sum % m;
        // if(localMax > max){
        // max = localMax;
        // }
        // for(int j =i -1;j>=0;j--){
        // sum += a.get(j);
        // localMax = sum %m;

        // if(localMax > max){
        // max = localMax;
        // }
        // if(max == m -1){
        // return max;
        // }
        // }
        // // sum = a.get(i);
        // // localMax = sum % m;
        // // if(localMax > max){
        // // max = localMax;
        // // }
        // if(max == m -1){
        // return max;
        // }
        // }
        if (a.size() == 1) {
            return a.get(0) % m;
        }
        long max = 0, localMax = 0;
        int mid = a.size() / 2;
        long maxLeft = maximumSum(a.subList(0, mid), m);
        long maxRight = maximumSum(a.subList(mid, a.size() - 1), m);
        long sumLeft = 0, sumRight = 0;
        for (int i = 0; i < a.subList(0, mid).size(); i++) {
            sumLeft += a.subList(0, mid).get(i);
            localMax = sumLeft % m;
            max = Math.max(max, localMax);
        }
        for (int i = mid; i < a.subList(mid, a.size() - 1).size(); i++) {
            sumRight += a.subList(mid, a.size() - 1).get(i);
            localMax = sumRight % m;
            max = Math.max(max, localMax);
        }
        max = Math.max(max, maxLeft);
        max = Math.max(max, maxRight);

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
