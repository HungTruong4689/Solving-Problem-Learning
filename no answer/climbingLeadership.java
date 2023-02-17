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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
     
    public static int binarySearch(List<Integer> arr, int left, int right, int x)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;
  
            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return mid;
  
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch(arr, mid + 1, right, x);
  
            // Else the element can only be present
            // in right subarray
            
            return binarySearch(arr, left, mid - 1, x);
        }
  
        // We reach here when element is not present
        // in array
        return -1;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> subArray = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int value =0;
         
        for(Integer elm: ranked){
            if(!subArray.contains(elm)){
                subArray.add(elm);
            }
        }
        Collections.sort(subArray, Collections.reverseOrder());
        
        
        for(Integer elem: player){
            if(subArray.contains(elem)){
                
                System.out.println(subArray);
                value = binarySearch(subArray,0,subArray.size()-1,elem);
                System.out.println(value);
                if(value>=0){
                    result.add(value+1);
                }
                
                
            }else{
                if(elem >= subArray.get(0)){
                    result.add(1);
                    subArray.add(elem);
                    Collections.sort(subArray, Collections.reverseOrder());
                }
                else if(elem <= subArray.get(subArray.size()-1)){
                    result.add(subArray.size()+1);
                    subArray.add(elem);
                    Collections.sort(subArray, Collections.reverseOrder());
                }else{
                    subArray.add(elem);
                    Collections.sort(subArray, Collections.reverseOrder());
                value = binarySearch(subArray,0,subArray.size()-1,elem);
            //System.out.println(value);
                    if(value>=0){
                        result.add(value+1);
                    }
                }
                
                
            }
            
            
            
            //result.add(subArray.indexOf(elem) + 1);
            // for(int j =0 ; j<subArray.size();j++){
            //     if(elem==subArray.get(j)){
            //         result.add(j+1);
            //         break;
            //     }
            // }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
