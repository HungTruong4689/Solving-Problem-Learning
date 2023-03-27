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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
    // Write your code here
        int even =0, odd =0;
        List<Integer> oddList = new ArrayList<Integer>();
        for(int i =0; i< B.size();i++){
            if(B.get(i) % 2 ==0){
                even++;
            }else{
                oddList.add(i);
            }
        }
        odd = B.size() - even;
        Collections.sort(oddList);
        int result =0;
        if(odd %2 !=0){
            return "NO";
        }else{
            int left =0;
            int right =1;
            //binary search
            while(right<oddList.size()){
                result += 2* (oddList.get(right)-oddList.get(left));
                left +=2;
                right +=2;
            }
            return Integer.toString(result);
        }
        //return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
