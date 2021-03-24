package Recursion;

import java.util.Arrays;

public class SortArray {
    // given a int array, sort it and return using recursion
    public static void main(String[] args){
        int[] array = {3,1,4,2,0};
        System.out.println("Unsorted array");
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
        sortArray(array, array.length);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }

    public static void sortArray(int[] array, int n){
        //base case, when the array size is 1
        if(n==1) {
            return;
        }
        for(int i=0; i<n-1; i++) {
            if(array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        sortArray(array, n-1);
    }
}
