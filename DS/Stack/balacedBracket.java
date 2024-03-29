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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static boolean balanceS(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean result = false;
        while (left < right) {
            int numLeft = s.charAt(left);
            int numRight = s.charAt(right);
            System.out.println(+s.charAt(left));
            System.out.println(+s.charAt(right));
            System.out.println(numLeft == numRight - 1 || numLeft == numRight - 2);
            if (numLeft == numRight - 1 || numLeft == numRight - 2) {
                result = true;

            } else {
                result = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("final: " + result);
        return result;
    }

    public static String isBalanced(String s) {
        // Write your code here
        if (s.length() % 2 != 0) {
            return "NO";
        }
        Stack<Character> apertura = new Stack<>();
        Stack<Character> cierre = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('(', ')');
        pairs.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            if (pairs.keySet().contains(s.charAt(i))) {
                apertura.push(s.charAt(i));
            } else {
                if (apertura.size() <= 0)
                    return "NO";
                Character aux = apertura.pop();
                if (s.charAt(i) == pairs.get(aux))
                    continue;
                else
                    return "NO";
            }
        }
        return (apertura.size() == 0 && cierre.size() == 0) ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
