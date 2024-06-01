package Algorithems;

public class InsertionSort {
	public static void insertionSort(int[] ar) {
        int n = ar.length;
        for (int i = 1; i < n; ++i) {
            int s = ar[i];
            int j = i - 1;

            // Move elements of ar[0..i-1], that are greater than selected, to one position ahead of their current position
            while (j >= 0 && ar[j] > s) {
                ar[j + 1] = ar[j];
                j = j - 1;
            }
            ar[j + 1] = s;
        }
    }

    public static void main(String[] args) {
        int[] ar = {22, 31, 13, 5, 16 ,45};
        System.out.println("Unsorted array:");
        for (int num : ar) {
            System.out.print(num + " ");
        }
        System.out.println();

        insertionSort(ar);

        System.out.println("Sorted array:");
        for (int num : ar) {
            System.out.print(num + " ");
        }
    }
	
}
