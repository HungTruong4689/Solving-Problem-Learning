
import java.util.*;

public class Solution {

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

    static void quickSort(int[] ar, int start, int end) {
        if (start < end) {
            int pivotValue = partition(ar, start, end);
            printArray(ar, 0, ar.length - 1);
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }
}
