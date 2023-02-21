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
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        int minNum = 0;
        int count =0;
        while(arr.size()>0){
            
            minNum = arr.get(0);
            for(int i =0;i<arr.size();i++){
                if(arr.get(i)<= minNum){
                    minNum = arr.get(i);
                }
            }
            result.add(arr.size());
            for(int j =0;j<arr.size();j++){
                arr.set(j,arr.get(j) - minNum);
                if(arr.get(j) != 0){
                    temp.add(arr.get(j));
                }
            }
            arr.clear();
            System.out.println("temp" +temp);
            
            for(int k =0;k<temp.size();k++){
                arr.add(temp.get(k));
            }
            temp.clear();
            System.out.println("first" +arr);
            
            // for(int k =0;k<arr.size();k++){
            //     //arr.set(j,arr.get(j) - minNum);
            //     if(arr.get(k) != 0 ){
            //         count++;
            //     }
            // }
            //result.add(count);
            System.out.println("second" +arr);
        }
        return result;
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

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
