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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */
    public static int checkString(String a, String b){
        int number =0;
        for(int i =0; i< a.length();i++){
            //System.out.println(a.charAt(i));
            int num1 = a.charAt(i);
            int num2 = b.charAt(i);
            int sum = num1 +num2;
            
            if(num1 +num2 >=97){
                number++;
            }
        }
        return number;
    }

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
        HashMap<Integer, Integer> sets = new HashMap<Integer, Integer>();
        List<Integer> results = new ArrayList<Integer>();
        for(int i =0; i<topic.size();i++){
            for(int j = i+1;j<topic.size();j++){
                int rel = checkString(topic.get(i),topic.get(j));
                //System.out.println("rel: " +rel);
                if(sets.keySet().contains(rel)){
                    int value = sets.get(rel);
                    value++;
                    //System.out.println("value: " +value);
                    sets.put(rel,value);
                }else{
                    sets.put(rel,1);
                    
                }
            }
        }
        
        int maxValue =0;
        for (Integer elm : sets.keySet()) {
            if(elm >= maxValue){
                maxValue = elm;
            }
        }
        
        System.out.println(sets);
        results.add(maxValue);
        results.add(sets.get(maxValue));
        
        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
