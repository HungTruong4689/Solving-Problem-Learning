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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    // Write your code here
        int[] arr = new int[26];
        for(int i =0; i < s.length();i++){// share a list of character
            int a = s.charAt(i) - 'a';
            arr[a]++;
        }
        int check = s.length() %2;
        int result =0;
        int even =0, odd =0;
        for(Integer elm : arr){
            System.out.print(elm + " ");
            if(elm >0){
                if(elm %2 ==0){
                    even++;
                }else{
                    odd++;
                }
            }
            
            result += (elm % 2);
        }
        System.out.println();
        System.out.println(even);
        System.out.println(odd);
        if(check == 0){
            if(odd >0){
                return "NO";//if odd >0
            }
            return "YES";
        }else if(check == 1 || result == 1 ){ // compare the check
           if(odd %2  ==1 && odd >1){// odd number
               return "NO";
           }
            return "YES";
        }else{
            return "NO";
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
