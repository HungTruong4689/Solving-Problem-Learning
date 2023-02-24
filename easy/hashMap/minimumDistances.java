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
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i =0; i< a.size();i++){
            
            
            if(map.keySet().contains(a.get(i))){
                List<Integer> list1 = new ArrayList<Integer>();
                list1 = map.get(a.get(i));
                list1.add(i);
                map.put(a.get(i),list1);
            }else{
                List<Integer> list2 = new ArrayList<Integer>();
                list2.add(i);
                map.put(a.get(i),list2);
            }
        }
        int minLength = Integer.MAX_VALUE;
        int count =0;
        for (List<Integer> i : map.values()) {
            if(i.size()<=1){
                count++;
            }else{
                int m = i.get(1) - i.get(0);
                if(m < minLength){
                    minLength =m;
                }
            }
        }
        if(count == map.size()){
            return -1;
        }else{
            return minLength;
        }
        // System.out.print(map);
        // return 1;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
