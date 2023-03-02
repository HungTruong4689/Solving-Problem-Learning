import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int swaps = 0;

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();
        int[] ar2 = ar.clone();
        quickSort(ar);

        int insertionSort = runningTime(ar2);
        System.out.println(insertionSort - swaps);
    }

    public static int runningTime(int[] arr) {
        // Write your code here
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                count++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
        // System.out.print(arr);
        return count;
    }

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

    static void quickSort(int[] ar, int start, int end) {
        if (start < end) {
            int pivotValue = partition(ar, start, end);
            // printArray(ar, 0, ar.length - 1);
            quickSort(ar, start, pivotValue - 1);
            quickSort(ar, pivotValue + 1, end);

        }

    }

    static int partition(int[] ar, int low, int hi) {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        int value = ar[hi];
        int i = low - 1;
        for (int j = low; j < hi; j++) {
            if (ar[j] < value) {
                i++;
                swap(ar, i, j);
            }
        }
        swap(ar, i + 1, hi);

        return i + 1;
    }

    // static void copy(List<Integer> list, int[] array, int startIndex) {
    // for (int num : list) {
    // array[startIndex++] = num;
    // }
    // }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swaps++;
    }

    static void printArray(int[] ar, int start, int end) {
        // for(int n: ar){
        // System.out.print(n+" ");
        // }
        for (int i = start; i <= end; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("");
    }

}
