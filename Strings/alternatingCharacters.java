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
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        // Write your code here
        int lastSeen = 0;
        int pos = 1;
        int init = 1;
        int count = 0;
        while (init < s.length()) {
            // if(init+1 == s.length() && s.charAt(0) != s.charAt(init)){
            // break;
            // }
            if (pos >= s.length()) {
                break;
            }
            init = pos;
            System.out.println("s : " + s);
            System.out.println("length " + s.length());
            System.out.println("init " + init);
            System.out.println("count: " + count);
            System.out.println("s.charAt(init) == lastSeen " + (s.charAt(init) == s.charAt(lastSeen)));
            if (s.charAt(init) == s.charAt(lastSeen)) {
                s = s.substring(0, init) + s.substring(init + 1, s.length());
                count++;

                init = 1;
            } else {
                lastSeen = init;
                init = lastSeen + 1;
                pos = init;
            }
        }
        return count;
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

                int result = Result.alternatingCharacters(s);

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
