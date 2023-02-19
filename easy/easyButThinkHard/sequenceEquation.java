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
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> getY = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i =0 ;i<p.size();i++){
            temp.add(p.get(i)-1);
        }
        
        for(int j =0 ;j<temp.size();j++){
            for(int n =0;n< temp.size();n++){
                if(temp.get(temp.get(n))==j){
                    
                    getY.add(n);
                }
            }   
        }
        System.out.println(getY);
        for(int k =0 ;k<getY.size();k++){
            result.add(getY.get(k)+1);
        }
        
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

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
