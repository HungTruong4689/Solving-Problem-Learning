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
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
        int total = 0;
        for(int i=1; i<s.length(); ++i){
            int[] tmpstr = new int[26];
            
            for(int j=i; j>=0; --j){
                tmpstr[s.charAt(j)-'a']++;
                
                for(int k=0; k<j; ++k){
                    int[] chars = new int[26];
                    int x = k;
                    int count =0;
                    while(count<=i-j){
                        ++chars[s.charAt(x)-'a'];
                        ++x;
                        ++count;
                    }
                    boolean flag = true;
                    for(x=0; x<26; ++x){
                        if(tmpstr[x]!=chars[x]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) ++total;   
                }
                
            }
        }
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
