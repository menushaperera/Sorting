package Algorithems;

public class MBubbleSort {
	 public static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        int newNum;

	        while (n > 1) {
	            newNum = 0;
	            for (int i = 1; i < n; i++) {
	                if (arr[i - 1] > arr[i]) {
	                    // Swap arr[i - 1] and arr[i]
	                    int temp = arr[i - 1];
	                    arr[i - 1] = arr[i];
	                    arr[i] = temp;
	                    newNum = i;
	                }
	            }
	            n = newNum;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {74, 34, 27, 52, 22, 15, 80};
	        System.out.println("Unsorted array:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();

	        bubbleSort(arr);

	        System.out.println("Sorted array:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	   
}
