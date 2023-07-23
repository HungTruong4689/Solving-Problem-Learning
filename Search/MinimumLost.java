import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static long minimumLoss(List<Long> price) {
        // Write your code here
        //TreeSet list
        TreeSet<Long> list = new TreeSet<Long>();
        //max value long
        long min = Long.MAX_VALUE;

        //size of price
        for (int i = 0; i < price.size(); i++) {
            //higher of the list
            Long header = list.higher(price.get(i));
            System.out.println("header " + header);
            //header is null or not
            if (header != null) {
                //min of value
                min = Math.min(header - price.get(i), min);

            }
            list.add(price.get(i));
        }
        System.out.println(list);

        return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] priceTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceTemp[i]);
            price.add(priceItem);
        }

        long result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
