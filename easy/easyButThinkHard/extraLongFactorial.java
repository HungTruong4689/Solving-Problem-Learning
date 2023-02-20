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
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
    // Write your code here
        // int result=0;
        // if (n ==0){
        //     result = 0;
        // }
        // if(n==1){
        //     result = 1;
        // }
        //BigInteger A;
        //A  = BigInteger.valueOf(n);
        //B  = BigInteger.valueOf(0);
        //return A.multiply(A-1);
        BigInteger x = BigInteger.valueOf(n);
        n = n-1;
        while(n>=1){
            x = x.multiply(BigInteger.valueOf(n));
            n--;
        }
        //result = n * extraLongFactorials(n-1);
        System.out.println(x);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
