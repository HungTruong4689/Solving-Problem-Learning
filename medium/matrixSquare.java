package medium;

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
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
     
    public static int absSum(List<Integer> a,List<Integer> b){
        int sumAbs=0;
        for(int i =0; i< a.size();i++){
            
                if(a.get(i) != b.get(i)){
                    sumAbs += Math.abs(a.get(i) - b.get(i));
                }
            
        }
        return sumAbs;
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.size(); i++) {
            // tiny change 1: proper dimensions
            for (int j = 0; j < s.get(i).size(); j++) { 
                // tiny change 2: actually store the values
                list.add(s.get(i).get(j)); 
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        // int[] s1 = new int[]{8,3,4,1,5,9,6,7,2};
        // List<Integer> listS1 = Arrays.stream(s1).boxed().collect(Collectors.toList());
        // int[] s2 = new int[]{6,1,8,7,5,3,2,9,4};
        // List<Integer> listS2 = Arrays.stream(s2).boxed().collect(Collectors.toList());
        // int[] s3 = new int[]{2,7,6,9,5,1,4,3,8};
        // List<Integer> listS3 = Arrays.stream(s3).boxed().collect(Collectors.toList());
        // int[] s4 = new int[]{4,9,2,3,5,7,8,1,6};
        // List<Integer> listS4 = Arrays.stream(s4).boxed().collect(Collectors.toList());
        
        int[][] matrix={{4,9,2,3,5,7,8,1,6},
                        {2,7,6,9,5,1,4,3,8},
                        {6,1,8,7,5,3,2,9,4},
                        {8,3,4,1,5,9,6,7,2},
                        {2,9,4,7,5,3,6,1,8},
                        {6,7,2,1,5,9,8,3,4},
                        {8,1,6,3,5,7,4,9,2},
                        {4,3,8,9,5,1,2,7,6}};
        for(int m=0;m<matrix.length;m++){
            List<Integer> change = Arrays.stream(matrix[m]).boxed().collect(Collectors.toList());
            result.add(absSum(change,list));
        }
        
        int finalResult=result.get(0);
        for(int k=0;k<result.size();k++){
            if(result.get(k)<finalResult){
                finalResult = result.get(k);
            }
        }
        
        // int[] test = new int[]{4,5,8,2,4,1,1,9,7};
        // List<Integer> testA = Arrays.stream(s4).boxed().collect(Collectors.toList());
        // System.out.println(absSum(listS1,testA));
        // System.out.println(absSum(listS2,testA));
        // System.out.println(absSum(listS3,testA));
        // System.out.println(absSum(listS4,testA));
        return finalResult;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

