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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
        List<Integer> containers = new ArrayList<Integer>();
        List<Integer> types = new ArrayList<Integer>();
        
        
        for(int i =0 ; i<container.size();i++){
            int sumContainer =0;
            for(int j =0; j< container.get(i).size();j++){
                sumContainer += container.get(i).get(j);
            }
            containers.add(sumContainer);
        }
        HashMap<Integer, Integer> cols = new HashMap<Integer, Integer>();
        
        for(int u =0; u< container.size();u++){
            cols.put(u,0);
        }
        
        for(int m =0;m <container.size();m++ ){
            for(int k =0;k <container.get(m).size();k++ ){
                
                if(cols.keySet().contains(k)){
                    int value = cols.get(k);
                    value += container.get(m).get(k);
                    //System.out.println("value: " +value);
                    cols.put(k,value);
                }
            }
        }
        for (Integer i : cols.values()) {
            types.add(i);
        }
        
        System.out.println(containers);
        System.out.println("types: "+ types);
        System.out.println("cols: "+ cols);
        Collections.sort(containers); 
        Collections.sort(types); 
         if (containers.equals(types) == true) {
            return "Possible";
        }
        else
        // else block execute when
        // ArrayList are not equal
        {
            return "Impossible";
        }
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
