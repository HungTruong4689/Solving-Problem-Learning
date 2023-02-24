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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */
    public static boolean checkNumber(long n){
        if(n ==1){
            return true;
        }
        long square = n * n;
        String strN = String.valueOf(n);
        String str = String.valueOf(square);
        if(str.length()> strN.length()){
            String subLeft = str.substring(0,str.length() - strN.length());
            String subRight = str.substring(str.length() - strN.length());
            long p = Long.parseLong(subLeft);
            long r = Long.parseLong(subRight);
            if(r ==0)return false;
            return n == p +r;
        }
        return false;
        
        
    }

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        int num =0;
        for(long i = p; i<= q; i++){
            if(checkNumber(i)){
                num++;
                System.out.print(i);
                System.out.print(" ");
            }
        }
        if(num ==0){
            System.out.print("INVALID RANGE");
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
