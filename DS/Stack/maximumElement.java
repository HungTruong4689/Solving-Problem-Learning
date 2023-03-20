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
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
    public static int maxStack(List<Integer> elm) {
        int max = 0;
        for (Integer el : elm) {
            if (el >= max) {
                max = el;
            }
        }
        return max;
    }

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        List<Integer> stack = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (String elm : operations) {
            if (elm.charAt(0) == '1') {
                String sub = elm.substring(2);
                int num = Integer.parseInt(sub);
                stack.add(num);
            } else if (elm.charAt(0) == '2') {
                int index = stack.size() - 1;
                if (index >= 0) {
                    stack.remove(index);
                }
            } else if (elm.charAt(0) == '3') {
                // System.out.println(stack.size());
                result.add(maxStack(stack));
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
