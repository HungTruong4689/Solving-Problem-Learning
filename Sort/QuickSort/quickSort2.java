

import java.util.*;
public class Solution {
	    
          static void quickSort(int[] ar) {
	    		quickSort(ar, 0, ar.length - 1);    	
	    }
        static void quickSort(int[] ar, int start, int end){
            if(start<end){
                int pivotValue = partition(ar,start,end);
                quickSort(ar, start, pivotValue-1);
                quickSort(ar,  pivotValue+1,end);
                printArray(ar, start, end);
            }
        }
        
        static int partition(int[] ar, int start,int end){
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        
        int value = ar[start];
        
        for(int i=start+1; i<=end;i++){
            if(ar[i] > value){
                right.add(ar[i]);
            }else{
                left.add(ar[i]);
            }
        }
        
        copy(left,ar,start);
        int newIndex = start + left.size();
        ar[newIndex] = value;
        copy(right,ar,newIndex+1);
        
        return newIndex;
        }
    static void copy(List<Integer> list, int [] array, int startIndex) {
        for (int num : list) {
            array[startIndex++] = num;
        }
    }
 
 static void printArray(int[] ar,int start, int end) {
			// for(int n: ar){
			// 	System.out.print(n+" ");
			// }
            for(int i = start;i<=end;i++){
                System.out.print(ar[i]+" ");
            }
	        System.out.println("");
		}
	    
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int i=0;i<n;i++){
	           ar[i]=in.nextInt(); 
	        }
	        quickSort(ar);
	    }    
	}
