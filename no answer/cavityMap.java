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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    
    public static boolean checkPosition(List<String> grid, int i, int j){
        int left = j -1;
        int right = j+1;
        int top = i -1;
        int bottom = i +1;
        int mainVal = 0;
        int leftVal =0, rightVal =0, topVal =0, botVal =0;
        if( left == -1 || right == grid.get(i).length() || top == -1 || bottom == grid.size()){
            return false;
        }else{
            
            mainVal = grid.get(i).charAt(j) - '0';
            leftVal = grid.get(i).charAt(left) - '0';
            rightVal = grid.get(i).charAt(right) - '0';
            topVal = grid.get(top).charAt(j) - '0';
            botVal = grid.get(bottom).charAt(j)- '0';
            if( leftVal == 88 || rightVal == 88 || topVal == 88 ||botVal == 88 ){
                return false;
            }
            else if( mainVal > leftVal && mainVal > rightVal && mainVal > topVal && mainVal > botVal ){ 
                return true;
            }
            return false;
        }
    }

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
        for(int i =0; i< grid.size();i++){
            for(int j =0; j < grid.get(i).length();j++){
                boolean change = checkPosition(grid,i,j);
                if(change == true){
                    grid.set(i,grid.get(i).replace(grid.get(i).charAt(j),'X'));
                    System.out.println(grid.get(i).replace(grid.get(i).charAt(j),'X'));
                }
            }
        }
        
        
        return grid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
