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
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
    // Write your code here
        
        // if(bc + wc < (2 * z)){
        //     result = b * bc + w * wc;
        // }else 
        // if ( bc > wc +z){
        //     //w = b +w;
        //     bc = wc +z;
        //     //result = b * z + w * wc;
        //     result = b * bc + w * wc;
        // }else if (wc > bc +z){
        //     wc = bc +z;
        //     //b = b+w;
        //     //result = b * bc + w * z;
        //     result = b * bc + w * wc;
        // }else{
        //     result = b * bc + w * wc;
        // }
        
        long result1 =0;
        long result2 =0;
        long result3 =0;
        long b1 = Long.valueOf(b);
        long bc1 = Long.valueOf(bc);
        long w1 = Long.valueOf(w);
        long wc1 = Long.valueOf(wc);
        long z1 = Long.valueOf(z);
        result1 = (long)(b1 * bc1 + w1 * wc1);
        result2 = (long)(b1 * z1 + (b1+w1) * wc1);
        result3 = (long)((b1+w1) * bc1 + w1 * z1);
        
        long result = result1;
        if(result> result2) result = result2;
        if(result> result3) result = result3;
        System.out.println(result);
        return result;
        
        // long minPriceWhite = (long) Math.min(bc, wc + z);
        // long minPriceBlack = (long) Math.min(wc, bc + z);
        // return (minPriceBlack * w) + (minPriceWhite * b);
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

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = Result.taumBday(b, w, bc, wc, z);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
