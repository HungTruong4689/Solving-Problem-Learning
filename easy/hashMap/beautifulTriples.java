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
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
    // Write your code here
        int result =0;
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        
        for(int i =0; i < arr.size();i++){
            if(list.keySet().contains(arr.get(i))){
                int value = list.get(arr.get(i));
                value++;
                list.put(arr.get(i), value);
            }else{
                list.put(arr.get(i), 1);
            }
        }
        System.out.println(list);
        
        for (Integer i : list.keySet()) {
            // System.out.println(i);
            // System.out.println(list.keySet().contains(i +d));
            // System.out.println(list.keySet().contains(i +2 *d));
            // System.out.println(list.get(i +d));
            if((list.keySet().contains(i +d)) && (list.keySet().contains(i +2*d))){
                // System.out.println(list.keySet().contains(i +2 *d));
                // System.out.println(list.get(i));
                
                result += list.get(i) * list.get(i +d) * list.get(i+2*d);
            }
            System.out.println(result);
        }
        
        // for(int i =0; i< arr.size()-2;i++){
        //     for(int j =i +1; j<arr.size()-1;j++){
        //         for(int k =j+1;k < arr.size();k++){
        //             if((arr.get(k)- arr.get(j) == d)&&(arr.get(j)- arr.get(i) == d)){
        //                 result++;
        //             }
        //         }
        //     }
        // }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
