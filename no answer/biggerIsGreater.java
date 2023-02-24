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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
        char[] arr = w.toCharArray();
        
        boolean found = false;
        int pivotIndex = -1;
        for(int i = arr.length -1 ; i>0; i--){
            if(arr[i]<= arr[i-1]) continue;
            found = true;
            pivotIndex = i - 1;
            break;
        }
        //System.out.println();
        if(!found) return "no answer";
        int rightMostIndex = -1;
        for(int i = arr.length -1; i>pivotIndex;i--){
            if(arr[i]> arr[pivotIndex]){
                rightMostIndex = i;
                break;
            }
        }
        System.out.println(rightMostIndex);
        
        
        
        char c = arr[pivotIndex];
        arr[pivotIndex] = arr[rightMostIndex];
        arr[rightMostIndex] = c;
        
        pivotIndex++;
        int left = pivotIndex++;
        int right = arr.length -1;
        while(left < right){
            c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            left++;
            right--;
        }
        
        return new String(arr);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
