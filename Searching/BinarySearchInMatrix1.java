package Searching;
import java.util.Scanner;
/*
* This is the Binary Search in Matrix pattern 1 , by Kunal kushwaha .
* Time complexity is : O(log mn)
* */
public class BinarySearchInMatrix1 {
    public static void main(String[] args) {
        int[][] arr = {
                {10 ,20 ,30 ,40},
                {11,22,33,44},
                {13,23 , 34, 45},
                {17 , 27 , 37 , 47}
        };

        int[][] index = binary(arr);

        if(index[0][0] == -1 && index[1][0] == -1){
            System.out.println("Element Not found !");
        }
        else{
            System.out.println("index of the target element is , Row : "+index[0][0]+" and Column : "+index[1][0]);
        }
    }

    private static int[][] binary(int[][] arr) {

        int r = 0 ;

        int c = arr[0].length-1 ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element : ");
        int target = sc.nextInt();
        while( r <= arr.length-1 && c >= 0 ){
            if(target < arr[r][c]){
                c-- ;
            }
            else if(target > arr[r][c]){
                r++ ;
            }
            else{
                int[][] result = {
                        {r},
                        {c}
                };
                return result ;
            }
        }
        int[][] result = {
                {-1},
                {-1}
        };
        return result ;
    }
}
