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
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */
    public static int findSmallest(List<Integer> arr){
        int min = arr.get(0);
        for(Integer elm: arr){
            if(elm <= min){
                min = elm;
            }
        }
        return min;
    }

    public static List<Integer> serviceLane(int n,List<Integer> width, List<List<Integer>> cases) {
    // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        // for(int i =0; i<cases.size(); i++){
        //     System.out.println(width);
        //     List<Integer> sublist = new ArrayList<Integer>();
        //     int start = cases.get(i).get(0);
        //     int end = cases.get(i).get(1) +1;
        //     sublist = width.subList(start, end);
        //     System.out.println(sublist);
        //     int min = Collections.min(sublist);
        //     result.add(min);
        // }
        cases.forEach(i ->{
            int start = i.get(0);
            int end = i.get(1) +1;
            List<Integer> sl = width.subList(start, end);
            int min = Collections.min(sl);
            result.add(min);
        });
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(n,width, cases);

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
