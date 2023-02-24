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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        
        int rows = (int)Math.floor(Math.sqrt(s.length()));
        int cols = (int)Math.ceil(Math.sqrt(s.length()));
        int max = rows * cols;
        System.out.println(rows);
        System.out.println(cols);
        System.out.println("max: "+max);
        System.out.println("first: "+s.length());
        
        //System.out.println("val: "+val);
        if(max> s.length()){
            int val = max - s.length();
            for(int i =0; i< val; i++){
                s += " ";
            }
            
        }else{
            rows++;
            max = rows *cols;
            int val = max - s.length();
            for(int i =0; i< val; i++){
                s += " ";
            }
        }
        System.out.println("second: "+s.length());
        List<String> str = new ArrayList<String>();
        while(s.length()>0){
            str.add(s.substring(0,cols));
            s = s.substring(cols);
        }
        HashMap<Integer, String> sets = new HashMap<Integer, String>();
        
        for(int u =0; u< str.get(0).length();u++){
            sets.put(u,"");
        }
        
        
        for(int m =0;m <str.size();m++ ){
            for(int k =0;k <str.get(m).length();k++ ){
                
                if(sets.keySet().contains(k)){
                    String value = sets.get(k);
                    value += str.get(m).charAt(k);
                    //System.out.println("value: " +value);
                    sets.put(k,value);
                }
            }
        }
        System.out.println(sets);
        String result ="";
        for (String i : sets.values()) {
            i = i.trim();
            result = result + i + " ";
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
