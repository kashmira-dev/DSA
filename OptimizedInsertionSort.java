
package algorithm;

public class OptimizedInsertionSort {

   
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

          
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

          
            arr[j + 1] = key;
        }
    }

    
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

   
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 1, 20};

        OptimizedInsertionSort ob = new OptimizedInsertionSort();
        ob.sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
/*
run:
Sorted array:
1 5 6 11 12 13 20 
*/