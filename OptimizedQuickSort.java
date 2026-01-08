
package recursion;
import java.util.Random;

public class OptimizedQuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 10;
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int partition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high); 
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }


    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, low, high);
                return;
            }

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

  
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 12, 3, 6, 4, 11};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

/*
Original array:
10 7 8 9 1 5 12 3 6 4 11 
Sorted array:
1 3 4 5 6 7 8 9 10 11 12
*/