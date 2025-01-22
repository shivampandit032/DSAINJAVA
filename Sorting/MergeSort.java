package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};

        merge(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static  void merge(int[] arr , int low , int high){
        if(low >= high){

            return  ;
        }

        int mid = low + (high - low )/2 ;

        merge(arr , low , mid);

        merge(arr , mid+1 , high);

        mergeSort(arr , low , mid , high);
    }
    static void mergeSort(int[] arr , int low , int mid , int high ){

        ArrayList<Integer> temp = new ArrayList<>();

        int s = low ;

        int e = mid+1;

        while(s <= mid && e <= high){
            if(arr[s] < arr[e]){
                temp.add(arr[s]);
                s++ ;
            }
            else if(arr[e] <= arr[s]){
                temp.add(arr[e]);

                e++ ;
            }
        }
        while(s <= mid){
            temp.add(arr[s]);
            s++ ;
        }
        while(e <= high){
            temp.add(arr[e]);
            e++;
        }

        for(int i = low ; i<=high ; i++){
            arr[i] = temp.get(i-low);
        }
    }
}
