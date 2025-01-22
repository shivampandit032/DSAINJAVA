package Queue;

public class Queue {
    int size = 5;

    int[] queue = new int[size];

    int front , rear , si = 0 ;

    void insert(int value){

        if(isFull()) {
            System.out.println("Queue is Full !");
            return ;
        }

        queue[rear] = value;

        rear++;

        si++;

        return ;
    }
    int delete(){
        if(isEmpty()){
            System.out.print("Queue is Empty !");

            return -1;
        }

        int number = queue[front];

        front++;
        si--;
        return number ;
    }

    boolean isFull() {
        if(si >= size){
            return true ;
        }
        return false ;
    }
    boolean isEmpty(){
        if(si <= 0 ){
            return true ;
        }
        return false ;
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        int[] arr = {5,4,3,2,1};
        for(int num : arr){
            q.insert(num);
        }

        q.insert(232);

        for(int i=0;i<5;i++){
            System.out.println(q.delete());
        }
        System.out.println(q.delete());
        System.out.println(q.delete());
        System.out.println(q.delete());
    }
}
