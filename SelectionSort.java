package Algorithems;

public class SelectionSort {
	 public static void selectionSort(int[] ar) {
	        int n = ar.length;

	        // One by one move boundary of unsorted
	        for (int i = 0; i < n - 1; i++) {
	            // Find the minimum element in unsorted array
	            int min = i;
	            for (int j = i + 1; j < n; j++) {
	                if (ar[j] < ar[min]) {
	                    min = j;
	                }
	            }

	            // Swap the found minimum element with the first element
	            int temp = ar[min];
	            ar[min] = ar[i];
	            ar[i] = temp;
	        }
	    }

	    public static void main(String[] args) {
	        int[] ar = {64, 15, 22, 42, 11 ,34};
	        System.out.println("Unsorted array:");
	        for (int num : ar) {
	            System.out.print(num + " ");
	        }
	        System.out.println();

	        selectionSort(ar);

	        System.out.println("Sorted array:");
	        for (int num : ar) {
	            System.out.print(num + " ");
	        }
	    }

}
