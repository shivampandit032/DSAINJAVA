package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        cyclic(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void cyclic(int[] arr){

        for(int i=0;i<arr.length;i++){

            int correctIndex = arr[i]-1;

            if(arr[correctIndex] != arr[i]){
                int temp = arr[correctIndex];

                arr[correctIndex] = arr[i];

                arr[i] = temp ;
            }
        }
    }
}
