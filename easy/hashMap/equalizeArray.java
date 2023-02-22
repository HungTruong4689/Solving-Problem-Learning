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
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        for(int i =0; i< arr.size();i++){
            if(list.get(arr.get(i)) == null){
                list.put(arr.get(i),1);
            }else{
                list.put(arr.get(i),list.get(arr.get(i)) +1);
            }
            
        }
        System.out.println(list);
        int maxValue = 0;
        int countOne =0;
        for (Integer i : list.values()) {
            if(i ==1){
                countOne++;
            }
            if(i >= maxValue){
                maxValue = i;
            }
        }
        if(countOne == arr.size()){
            return arr.size() - 1;
        }else{
            return arr.size() - maxValue;
        }
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
