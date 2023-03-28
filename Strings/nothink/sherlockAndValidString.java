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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        int[] arr = new int[26];
        for(int i =0 ; i < s.length();i++){
            int a = s.charAt(i) - 'a';
            arr[a]++;
        }
        int result =0;
        List<Integer> sub = new ArrayList<Integer>();
        
        for(int i =0; i < arr.length;i++){
            //System.out.print(arr[i] + " ");
            if(arr[i]>0){
                sub.add(arr[i]);
            }
        }
        Collections.sort(sub);
        System.out.println(sub);
        int size = sub.size();
        if(sub.get(size-1) ==sub.get(0)){
            return "YES";
        }
        if(sub.get(0) == 1 && sub.get(1) == sub.get(size-1) ){
            return "YES";
        }
        
        // if(sub.get(size-1) ==1){
        //     return "YES";
        // }
        
        if( sub.get(0) ==sub.get(1) && sub.get(1) ==sub.get(size-2)&&   sub.get(size-1) ==sub.get(size-2) +1){
            return "YES";
        }
        return "NO";
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
