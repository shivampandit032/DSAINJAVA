package JAVAConcepts;

import java.util.*;

public class ArrayListInJava {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);

        System.out.println(arr);

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ;i<5 ;i++){

            arr.add(i);
        }

        for(int i=0;i<arr.size() ; i++){
            System.out.println(arr.get(i));
        }
    }
}
