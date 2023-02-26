import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        
        if(n == c.length){
            return 0;
        }
        int[] list = new int[n];
        int left = 0;
        int right =0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i =0; i<n;i++){
            list[i] =0;
            for(int j =0;j<c.length;j++){
                
                if(i == c[j]){
                    list[i] = 1;
                    break;
                }
                    
                
            }
        }
        for( Integer elm: list){
            System.out.print(elm + " ");
        }
        for(int i =0; i< list.length;i++){
            System.out.println("case: "+ i);
            if(list[i]==1){
                result.add(0);
            }else{
                for(int j = i-1;j>=0;j--){
                    if(list[j]==1){
                        left = i-j;
                        break;
                    }
                }
                for(int k =i+1;k<list.length;k++){
                    if(list[k]==1){
                        right = k -i;
                        break;
                    }
                }
                System.out.println("left: "+ left);
                System.out.println("right: "+ right);
                int shortD = left < right ? left : right;
                System.out.println("short: "+ shortD);
                result.add(shortD);
                
            }
            System.out.println("result: "+ result);
        }
        int max =0;
        System.out.println(result);
        for(Integer elm: result){
            if(elm>max){
                max = elm;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
