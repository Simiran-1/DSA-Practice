import java.util.ArrayList;

public class BST1 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
          root.left=  insert(root.left, val);
        }

        else{
            root.right=insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static boolean search(Node root,int key){
        if(root==null) return false;
        if(root.data>key){
            return search(root.left, key);
        }
        else if(root.data==key){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data > val){
            root.left=delete(root.left, val);
        }
        else if(root.data<val){
            root.right=delete(root.right, val);
        }
        else{

            //case1
            if(root.left==null && root.right==null){
                return null;
            }

            //case2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case3
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);

        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;

    }

    public static void printInrange(Node root,int x,int y){
        if(root==null) return;

        if(root.data>=x && root.data<=y){
            printInrange(root.left, x, y);
            System.out.print(root.data+" ");
            printInrange(root.right, x, y);
        }
        else if(root.data >= y){
            printInrange(root.left, x, y);
        }
        else {
            printInrange(root.right, x, y);
        }
    }


    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void printRoot(Node root,ArrayList<Integer> path){
        if(root==null) return;

        path.add(root.data);

        //leaf
        if(root.left==null && root.right==null){
            printPath(path);
        }
        else{
            printRoot(root.left, path);
          printRoot(root.right, path);
        }
       
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        // if(search(root, 7)){
        //     System.out.println("found");
        // }
        // else{
        //     System.out.println("Not found");
        // }

        // delete(root, 4);
        // inorder(root);
        // printInrange(root, 1, 10);
        printRoot(root, new ArrayList<>());
    }
}
