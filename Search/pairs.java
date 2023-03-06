import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        // TreeSet<Integer> list = new TreeSet<>();
        // for(int i =0;i<arr.size();i++){
        // Integer higher = list.higher(arr.get(i));
        // if(higher != null && (higher - arr.get(i)) == k){
        // count++;
        // }
        // list.add(arr.get(i));
        // }
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (Math.abs(arr.get(i) - arr.get(j)) == k) {
                    count++;
                } else if (Math.abs(arr.get(i) - arr.get(j)) > k) {
                    break;
                }
            }
            // if(arr.contains(k+arr.get(i))){
            // count++;
            // //arr.remove(i);
            // System.out.println(arr);
            // }
        }
        // int pos =0;
        // boolean check =true;
        // while(check){
        // if(arr.contains(k + arr.get(pos))){
        // arr.remove(pos);
        // count++;
        // pos =0;
        // }else{
        // pos++;
        // }
        // if(pos>arr.size()-1){
        // check = false;
        // }
        // }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
