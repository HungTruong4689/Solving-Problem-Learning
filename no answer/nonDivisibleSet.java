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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        int result = 0;
        //hashset to take unique value
        HashSet<Integer> sets = new HashSet<Integer>();
        //array list
        List<Integer> list = new ArrayList<Integer>();
        
        int[] remains=new int[k];
        for (int i=0;i<s.size();i++){
            remains[s.get(i)%k]++;
        }
        //compare 1 with the list
        result += Math.min(remains[0],1);
        for (int i=1;i<remains.length;i++){
            if(i==(k-i)){
                //increase value of list
                result++;
            }else {
                if (remains[i]>=remains[k-i]){
                    //increase remains
                    result+=remains[i];
                }else {
                    //increase remains k - i
                    result+=remains[k-i];
                }
                //assign 0 to i
                remains[i]=0;
                //assign 0 to k-i
                remains[k-i]=0;
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
