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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        boolean lowercase = false;
        boolean uppercase = false;
        boolean number = false;
        boolean special = false;
        char[] schars = "!@#$%^&*()-+".toCharArray();
        Set<Character> cs = new HashSet<>();
        for (char c : schars) {
            cs.add(c);
        }
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9')
                number = true;
            if (c >= 'a' && c <= 'z')
                lowercase = true;
            if (c >= 'A' && c <= 'Z')
                uppercase = true;
            if (cs.contains(c))
                special = true;
        }
        int need = 0;
        need += lowercase ? 0 : 1;
        need += uppercase ? 0 : 1;
        need += number ? 0 : 1;
        need += special ? 0 : 1;
        return n + need < 6 ? 6 - n : need;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
