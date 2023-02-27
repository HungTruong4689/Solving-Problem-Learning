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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */
    public static boolean checkarr(List<Integer> arr){
        int count =0;
        for(int i =1; i< arr.size();i++){
            if(arr.get(i)- arr.get(i-1) == 1){
                count++; 
            }
        }
        if( arr.size()-1 ==1){
            return false;
        }
        else if(count == arr.size()-1){
            return true;
        }else{
            return false;
        }
    }

    public static String happyLadybugs(String b) {
    // Write your code here
        HashMap<Character, List<Integer>> sets = new HashMap<Character, List<Integer>>();
        
        for (int i =0; i< b.length();i++){
            if(!sets.keySet().contains(b.charAt(i))){
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                sets.put(b.charAt(i),list);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list = sets.get(b.charAt(i));
                list.add(i);
                sets.put(b.charAt(i),list);
            }
        }
        System.out.println(sets);
        if(sets.keySet().contains('_')  ){
            for (Character i : sets.keySet()) {
                if(sets.get(i).size() <2 && i != '_'){
                    return "NO";
                }
            
            }
            if(sets.get('_').size() == b.length()){
                return "YES";
            }else{
                return "YES";
            }
            
        }
        else if(!sets.keySet().contains('_')){
            int count =0;
            for (Character i : sets.keySet()) {
                if(checkarr(sets.get(i))){
                    count++;
                }
                if(sets.get(i).size() ==1){
                    return "NO";
                }
            
            }
            if(count == sets.size()){
                return "YES";
            }else{
                return "NO";
            }
            
            
        }else{
             return "YES";
        }
        
        //return "YES";
        
       
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

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
