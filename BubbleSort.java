package Algorithems;

import java.util.ArrayList;

public class BubbleSort {
	public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap list[j] and list[j + 1]
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Method to print the elements of the ArrayList
    public static void printList(ArrayList<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(64);
        list.add(34);
        list.add(25);
        list.add(12);
        list.add(22);
        list.add(11);
        list.add(90);

        System.out.println("Unsorted list:");
        printList(list);

        bubbleSort(list);

        System.out.println("Sorted list:");
        printList(list);
    }

}
