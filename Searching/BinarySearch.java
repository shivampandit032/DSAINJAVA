package Searching;
import java.util.Scanner ;
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        int index = binary(arr);

        if(index == -1){
            System.out.println("Element isn't present !");
        }
        else {
            System.out.println("index of the target element is : "+index);
        }
    }

    private static int binary(int[] arr) {
        int n = arr.length;

        int s = 0 ;

        int e = n-1;

        System.out.println("Enter the element you want to search : ");
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        while (s<=e){

            int mid = s + (e - s)/2 ;

            if(target < arr[mid]){
                e = mid - 1;
            }
            else if (target > arr[mid]){
                s = mid + 1 ;
            }
            else{
                return mid;
            }
        }
        return -1 ;
    }
}
