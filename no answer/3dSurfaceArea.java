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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
    // Write your code here
        int surface =0;
        int m = A.size(), n = A.get(0).size();
        int bottomArea = m *n;
        int topArea = bottomArea;
        int frontArea =0, rearArea =0, leftArea =0, rightArea =0;
        surface += topArea + bottomArea;
        // front and rear
        for(int i =0; i <A.get(0).size();i++){
            frontArea += A.get(0).get(i);
            rearArea += A.get(m-1).get(i);
        }
        for(int i =1;i<m;i++){
            for(int j =0;j<n;j++){
                //get the front area
                frontArea += A.get(i).get(j) > A.get(i-1).get(j) ? (A.get(i).get(j) - A.get(i-1).get(j)) :0;
                rearArea += A.get(m-i-1).get(j)>A.get(m-i).get(j) ?(A.get(m-i-1).get(j) -A.get(m-i).get(j))   :0;
            }
        }
        
        //left and right
        for(int i =0; i <A.size();i++){
            leftArea += A.get(i).get(0);
            rightArea += A.get(i).get(n-1);
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<m;j++){
                leftArea += A.get(j).get(i) > A.get(j).get(i-1) ? (A.get(j).get(i) - A.get(j).get(i-1)) :0;
                rightArea += A.get(j).get(n-i-1)>A.get(j).get(n-i) ?(A.get(j).get(n-i-1) -A.get(j).get(n-i) )  :0;
            }
        }
        surface += frontArea + rearArea + leftArea + rightArea;
        
        return surface;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
