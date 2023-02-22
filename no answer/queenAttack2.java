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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */
      
     
     
     public static int direction(int rowV, int colV, int r_q, int c_q,int n,HashSet<String> sets ){
         int row = 0;
         int col = 0;
         row = r_q + rowV;
         col = c_q + colV;
         int numberSquare =0;
         while(row>0 && row<=n && col>0 && col<= n){
             if(sets.contains(row +":"+col)) break;
             col+=colV;
             row+=rowV;
             numberSquare++;
             
             
         }
         return numberSquare++;
     }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        HashSet<String> sets = new HashSet<String>();
        for(int i =0;i<obstacles.size();i++){
            
            sets.add(obstacles.get(i).get(0)+ ":"+obstacles.get(i).get(1));
            
        }
        System.out.println(sets);
        
    //     direction(1, 1)
    // direction(1, -1)
    // direction(-1, 1)
    // direction(-1, -1)
    // direction(0, 1)
    // direction(1, 0)
    // direction(0, -1)
    // direction(-1, 0)
        return direction(1,1,r_q,c_q,n,sets) +direction(1,-1,r_q,c_q,n,sets) +direction(-1,1,r_q,c_q,n,sets) +direction(-1,-1,r_q,c_q,n,sets)+direction(0,1,r_q,c_q,n,sets)+direction(1,0,r_q,c_q,n,sets)+direction(0,-1,r_q,c_q,n,sets)+direction(-1,0,r_q,c_q,n,sets);
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
