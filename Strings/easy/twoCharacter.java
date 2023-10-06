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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
            // Write your code here
        int maxPattern = 0;

        if  (s.length() == 1)/ / Edge case where length is 1
        {
            return maxPattern; //return value
        }

        //  Loop through all letter pairs
        for  (int i = 0; i < 26; i++     nextLetter: for (int j = i + 1; j < 26; j++) {
                char on      char two = (char) ('a' + j)     char lastSeen = '\u0000';
                int patternLength = 0; 
 
                for (char letter : s.toCharArray()) {
                    if (letter == one || letter == two) {
        if (letter == lastSeen)// Duplicate found
                         {             continue nextLetter;
                         }     // Not a duplicate
                        pa tternLength++; 
                        lastSeen = letter;
                    }
                } // for char : s
 
                maxPattern = (patternLength > maxPattern) ? patternLength : maxPattern; // Keep a running max

            } // for j
        } // for i
    axPattern;}

    }

public c Solution{

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
