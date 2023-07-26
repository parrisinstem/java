package sort.bubble;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("PRE SORT: " + Arrays.toString(nums));
        
        bubbleSortUnoptimized(nums.clone());
        bubbleSort(nums);
        
        System.out.println("POST SORT: " + Arrays.toString(nums));
    }
    
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public static void bubbleSortUnoptimized(int[] arr) {
        int iterationCount = 0;
        for (int el : arr) {
            for (int index = 0; index < arr.length - 1; index++) {
                iterationCount++;
                if (arr[index] > arr[index + 1]) {
                    swap(arr, index, index + 1);
                }
            }
        }
        
        System.out.println("PRE-OPTIMIZED ITERATION COUNT: " + iterationCount);
    }
    
    public static void bubbleSort(int[] arr) {
        int iterationCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int idx = 0; idx < arr.length - i - 1; idx++) {
                iterationCount++;
                if (arr[idx] > arr[idx + 1]) {
                    int temp = arr[idx];
                    arr[idx] = arr[idx + 1];
                    arr[idx + 1] = temp;
                }
            }
        }
        
        System.out.println("POST-OPTIMIZED ITERATION COUNT: " + iterationCount);
    }
}
