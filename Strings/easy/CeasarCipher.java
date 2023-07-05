package easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import Result;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        String result = "";
        int rem = k % 26; //check the range of character
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            int a = s.charAt(i) + rem;
            if (val > 64 && val < 91) { //the range of alphabet
                if (a > 90) {
                    a = 65 + a - 91;
                }
            } else if (val > 96 && val < 123) {
                if (a > 122) {
                    a = 97 + a - 123;
                }
            } else {
                a = val;
            }

            System.out.println(a);
            String b = Character.toString((char) a);
            System.out.println(b);
            result += b;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
