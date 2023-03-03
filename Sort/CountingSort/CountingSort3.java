import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        final int maxValue = 100;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[maxValue];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            in.next();
            arr[num]++;

        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            System.out.print(count + " ");
        }

    }
}
