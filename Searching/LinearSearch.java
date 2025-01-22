package Searching;

// Worst Case time complexity of Linear Search Algorithm is : O(N)

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        int index = linear(arr);

        if(index == -1){
            System.out.println("Element isn't present !");
        }
        else{
            System.out.println("The index of the target element is : "+index);
        }

    }
    public static int linear(int[] arr){
        int n = arr.length;
        System.out.println("Enter the element you want to search : ");
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        for (int i = 0 ;i<n; i++){

            if(target == arr[i]){
                return i ;
            }
        }
        return -1 ;
    }
}
