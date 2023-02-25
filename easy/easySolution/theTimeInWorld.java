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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */
     
    public static String hourToString(int h){
        String[] hours = {"","one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve"};
        return hours[h];
    }
    public static String minuteToString(int m){
        String[] minutes = {"o' clock","one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "quarter",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen", "twenty", "twenty one",
    "twenty two",
    "twenty three",
    "twenty four",
    "twenty five",
    "twenty six",
    "twenty seven",
    "twenty eight",
    "twenty nine", "half past"};
        return minutes[m];
    }

    public static String timeInWords(int h, int m) {
    // Write your code here
        String hour = "";
        String minute = "";
        if(m == 0){
            hour = hourToString(h);
            minute = minuteToString(m);
            return hour + " " + minute;
        }else if(m == 30){
            hour = hourToString(h);
            minute = minuteToString(m);
            return minute + " "+ hour;
        }else if( m>0 && m <30){
            hour = hourToString(h);
            minute = minuteToString(m);
            if(m ==15){
                return minute + " past "+ hour;
            }else if(m ==1){
                return minute + " minute past "+ hour;
            }
            else{
                return minute + " minutes past "+ hour;
            }
        }else{
            int val = 60 -m;
            hour = hourToString(h+1);
            minute = minuteToString(val);
            if(val ==15){
                return minute + " to "+ hour;
            }else if(val ==1){
                return minute + " minute to "+ hour;
            }
            else{
                return minute + " minutes to "+ hour;
            }
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
