package Tree;

import javax.swing.text.Segment;

public class SegmentTree {
    public class Node{
        int value ;

        Node left ;

        Node right;

        int startInterval ;

        int endInterval ;

        Node(int start , int end){
            startInterval = start ;

            endInterval = end;
        }


    }

    public Node root ;
// constructor of Segment Tree class

    SegmentTree(int[] arr ){

        this.root = constructor(arr , 0 , arr.length-1);
    }

    Node constructor(int[] arr , int s , int e){
        if(s >= e){

            Node leaf = new Node(s , e);

            leaf.value = arr[s];

            return leaf ;
        }

        Node node = new Node(s , e);

        int mid = (s + e) / 2;

        node.left = constructor(arr , s , mid);

        node.right = constructor(arr , mid+1 , e);

        node.value = node.left.value + node.right.value;

        return node;
    }

    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.value + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.value + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.value;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

    // operation or query function

    int query(int start , int end){

       return query(root , start , end);
    }
    int query(Node node , int qsi, int qei){

        if (node.startInterval >= qsi && node.endInterval <= qei){

            return node.value ;
        }
        else if(node.startInterval > qei || node.endInterval < qsi ){
            return 0 ;
        }

        else{

            int numFromLeft = query(node.left , qsi , qei);

            int numFromRight = query(node.right , qsi , qei);

            return numFromLeft + numFromRight;


        }
    }
    // update
    public void update(int index, int value) {
        this.root.value = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval&& index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.value = value;
                return node.value;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.value = leftAns + rightAns;
                return node.value;
            }
        }
        return node.value;
    }
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree s = new SegmentTree(arr);

        s.display();

        System.out.println(s.query(1,5));


    }
}
