package Tree;

public class AVLTree {

    public class Node{

        int value ;

        Node left;

        Node right ;

        int height ;

        Node(int value){
            this.value = value;

            this.left = null;

            this.right = null;

            this.height = 0;
        }
    }

    Node root;

    AVLTree(){
            root = null;
    }

    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    void insert(int value){
        if(root == null){

            root = new Node(value);

            return ;
        }
        root = insert(root , value);
    }
    Node insert(Node node , int value){
        if(node == null){
         node = new Node(value);

         return node ;
        }
        if(value < node.value){
            node.left = insert(node.left , value);
        }
        if(value > node.value){
            node.right = insert(node.right , value);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return rotate(node) ;
    }
    Node rotate(Node node){

        if(getHeight(node.left) - getHeight(node.right) > 1){
            // left heavy case
            if(getHeight(node.left.left) - getHeight(node.left.right) > 0){
                // left left case

                return rightRotate(node);
            }
            if(getHeight(node.left.left) - getHeight(node.left.right) < 0){
                // left right case

                 node.left = leftRotate(node.left);
                 return rightRotate(node);
            }
        }
        if(getHeight(node.left) - getHeight(node.right) < -1){
            // right heavy case

            if(getHeight(node.right.left) - getHeight(node.right.right) < 0){
                // right right case
                return leftRotate(node);
            }
            if(getHeight(node.right.left) - getHeight(node.right.right) > 0){
                // right left case

                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
    Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;;

        c.right = p;

        p.left = t;

        p.height = Math.max(getHeight(p.left) , getHeight(p.right))+1;

        c.height = Math.max(getHeight(c.left) , getHeight(c.right)) + 1;

        return p;

    }

    Node leftRotate(Node p){
        Node c = p.right ;
        Node t = c.left;

        c.left = p;

        p.right = t;

        p.height = Math.max(getHeight(p.left) , getHeight(p.right))+1;

        c.height = Math.max(getHeight(c.left) , getHeight(c.right))+1;

        return c;
    }
    void display(Node node,String str){
        if(node == null){
            return ;
        }
        System.out.println(node.value+str);

        display(node.left," is in left node of "+node.value);
        display(node.right , " is in right node of "+node.value);

    }
    boolean balanced(Node node){
        if(node == null){
            return true ;
        }

        return (Math.abs(getHeight(node.left)-getHeight(node.right))<=1) && (balanced(node.left)) && (balanced(node.right));
    }
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        for(int i = 0 ; i< 1000 ; i++){
            avl.insert(i);
        }
        System.out.println(avl.getHeight(avl.root));
    }

}
