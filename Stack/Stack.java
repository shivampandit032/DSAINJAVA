package Stack;
/*
ADTs of stack : push() , pop() and peek() .
it follows " Last in First Out Principle ".
 */
public class Stack {

    int n = 5;
    int[] arr = new int[n];

    int ptr = -1;

     void push(int num){

        if(isFull()){

            System.out.println("Stack is Full !");

            return ;
        }

        ptr++;

        arr[ptr] = num ;

        return ;
    }

     int pop(){
        if(isEmpty()){
            System.out.print("Stack is Empty! ");

            return -1;
        }

        int number = arr[ptr];

        ptr--;

        return number ;
    }

    boolean isFull(){
         if(ptr >= n-1){
             return true ;
         }
         return false ;
    }
    boolean isEmpty(){
         if(ptr == -1){
             return true ;
         }
         return false;
    }

    int peek(){
         return arr[ptr];
    }

    public static void main(String[] args) {
         Stack stack = new Stack();

         int[] arr = {5,4,3,2,1};

         for(int a : arr){
             stack.push(a);
         }
         stack.push(333);
         for(int i = 0 ; i< 5 ; i++){
             System.out.print(stack.pop()+" -> ");
         }
        System.out.println();
        System.out.println(stack.pop());
    }
}
