package Algorithms;

import java.util.Arrays;
public class QuickSort {
	public static void main(String args[]) {
		int[] input = {23,31,1,21,36,72};
		System.out.println("Before Sorting: "+ Arrays.toString(input));
		quickSort(input);
		System.out.println("After Sorting: "+ Arrays.toString(input));
	}
	
	public static void quickSort(int[] array) {
		recursiveQuickSort(array, 0, array.length - 1);
	}
	
	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
		int idx = partition(array, startIdx, endIdx);
		
		if(startIdx < idx - 1) {
			recursiveQuickSort(array, startIdx, endIdx);
		}
		
		if(endIdx > idx) {
			recursiveQuickSort(array, idx, endIdx);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		int pivot = array[left];
		
		while(left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right]=tmp;
				
				left++;
				right--;
			}
		}
		return left;
	}
}
