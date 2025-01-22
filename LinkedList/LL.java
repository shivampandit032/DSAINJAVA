package LinkedList;

public class LL{
    LL(){

    }
    Node head = null;

    public static class Node{
        int data  ;

        Node next  ;

        Node(int value){
            this.data = value ;
            this.next = null ;
        }

    }

    void insertatHead(int value){
        if(this.head == null){
            Node node = new Node(value);

            node.next = head;

            head = node ;
            return ;
        }
        Node node = new Node(value);

        node.next = head;

        head = node;
        return ;
    }

    void display(){

        Node temp = this.head ;

        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next ;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {

        LL ll = new LL();

        for(int i = 0 ; i< 5 ; i++){

            ll.insertatHead(i);
        }

        ll.display();
    }
}