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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */
    public static boolean checkPalin(String s) {
        int i =0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
        //int i =0;
        //int j = s.length()-1;
        int need =0;
        StringBuilder input = new StringBuilder(s);
        //input value
        for(int i =0;i<n/2;i++){
            char left = input.charAt(i);
            char right = input.charAt(n-1-i);
            if(left != right){
                need++;
            }
        }
        if(need > k){
            return "-1";
        }else{
            int free = k - need;
            for(int i =0; i < n/2;i++){
                char left = input.charAt(i);
                char right = input.charAt(n-1-i);
                if(free >= 2){
                    if(left != right){
                        free++;
                    }
                    if(left != '9'){
                        input.setCharAt(i,'9');
                        free--;
                    }
                    if(right != '9'){
                        input.setCharAt(n-1-i,'9');
                        free--;
                    }
                }else if (free == 1){
                    if(left != right){
                        if(left == '9' || right == '9') free++;
                        if(left != '9'){
                            input.setCharAt(i,'9');
                            free--;
                        }
                        if(right != '9'){
                            input.setCharAt(n-1-i,'9');
                            free--;
                        }
                    }
                }else{
                    if(left != right){
                        if(left > right){
                            input.setCharAt(n-1-i,left);
                        }else{
                            input.setCharAt(i,right);
                        }
                    }
                }
            }
            if(n %2 == 1 && free >0) input.setCharAt(n/2, '9');
        }
        
        
        
        return input.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
