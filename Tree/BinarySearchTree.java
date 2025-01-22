package Tree;

public class BinarySearchTree {

    Node root ;

    void BinaryTree(){
        this.root = null;
    }

    public class Node{
        int value ;

        Node left ;

        Node right ;

        int height ;

        Node(int value){
            this.value = value ;

            this.left = null;

            this.right = null;

            this.height = 0 ;
        }
    }

    void populate(int value){
        if(this.root == null){
            root = new Node(value);

            return ;
        }
        root = populate(root , value);
    }
    Node populate(Node node , int value){
        if(node == null){
            node = new Node(value);

            return node ;
        }
        if(value < node.value){
            node.left = populate(node.left , value);

        }
        if(value > node.value){
            node.right = populate(node.right,value);
        }

        return node ;
    }
    void preOrder(Node node){
        if(node == null){
            return ;
        }
        System.out.print(node.value+" -> ");
        preOrder(node.left);
        preOrder(node.right);
    }
    void inOrder(Node node){
        if(node == null){
            return ;
        }

        inOrder(node.left);

        System.out.print(node.value+" -> ");

        inOrder(node.right);
    }
    void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" -> ");
    }
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();

        int[] arr = {5,34,3,33,1234,213};

        for(int a : arr){
            bt.populate(a);
        }

        bt.preOrder(bt.root);
        System.out.println();

        bt.inOrder(bt.root);

        System.out.println();

        bt.postOrder(bt.root);
        System.out.println();



    }
}