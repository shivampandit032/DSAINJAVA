package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        quick(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
    static void quick(int[] arr ,int low , int high){
        if(low >= high){
            return ;
        }
        int s = low ;
        int mid = low+(high - low)/2;
        int pivot = arr[mid];
        int e = high;

        while(s<=e){
            if(arr[s] <pivot){

                s++;

            }
            else if(arr[e] >= pivot ){

                e--;

            }

            if(s<=e){

                int temp = arr[s];

                arr[s] = arr[e];

                arr[e] = temp ;

                s++;
                e--;

            }
        }

        quick(arr , low , e);
        quick(arr , s , high);

    }
}
