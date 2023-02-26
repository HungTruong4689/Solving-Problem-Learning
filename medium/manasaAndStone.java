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
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */
     
     

    public static List<Integer> stones(int n, int a, int b) {
    // Write your code here
        //int caseNum =0;
        // List<Integer> result = new ArrayList<Integer>();
        // List<Integer> list1 = new ArrayList<Integer>();
        // List<Integer> list2 = new ArrayList<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for(int i =0; i< n;i++){
            int init=0;
            if(i==0){
                init += (a* (n-1));
                result.add(init);
            }else if(i == n-1){
                init += (b* (n-1));
                result.add(init);
            }else{
                init += (a*i);
                init += (b*(n-1-i));
                result.add(init);
            }
        }
        // System.out.println(caseNum);
        // caseNum = caseNum/2;
        // for(int i=0;i<caseNum;i++){
        ArrayList<Integer> last
            = new ArrayList<>(result);
            
        // }
        Collections.sort(last);
        return last;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.stones(n, a, b);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
