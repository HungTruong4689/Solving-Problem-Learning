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
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
    // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        
        if(k==0){
            for(int i =1; i<=n;i++){
                //add the new number to list
                result.add(i);
            }
            // see the number if divided into 2
        }else if( n% 2==0 && n %(2*k)==0){
            int blocks = n / k;
                int currentNumber = k;
                // blocks
                for (int i = 0; i < blocks; i++) {
                    for (int j = 0; j < k; j++) {
                        currentNumber++;
                        result.add(currentNumber);

                    }
                    //watch the currentNumber
                    if (i % 2 != 0) {
                        currentNumber = currentNumber + (2 * k);
                    } else {
                        currentNumber = currentNumber - (2 * k);
                    }
                }
        }else{
            result.add(-1);
        }
        
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
