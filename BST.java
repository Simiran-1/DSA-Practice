import java.util.*;
import java.util.LinkedList;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                 System.out.println();
                 if(q.isEmpty()){
                    break;
                 }
                 else{
                    q.add(null);
                 }
            }
            else{
               System.out.print(currNode.data+" ");
               if(currNode.left !=null){
                q.add(currNode.left);
               }
               if(currNode.right !=null){
                q.add(currNode.right);
               }
            }
        }
    }

    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int leftNode=countNode(root.left);
        int rightNode=countNode(root.right);

        return leftNode + rightNode +1;
    }

    public static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }

        int leftSum=sumOfNode(root.left);
        int rightSum=sumOfNode(root.right);

        return leftSum+rightSum+root.data;
    }


    public static int height(Node root){
        if(root==null) return 0;

        int leftheight=height(root.left);
        int rightheight=height(root.right);

        int maxheight=Math.max(leftheight,rightheight)+1;

        return maxheight;

    }


    public static int diameter(Node root){
        if(root==null){
            return 0;
        }

        int dia1=diameter(root.left);
        int dia2=diameter(root.right);
        int dia3=height(root.left)+height(root.right)+1;

        int max=Math.max(dia3,Math.max(dia1, dia2));

        return max;
    }


    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
         return  new TreeInfo(0,0);
        }

        TreeInfo left=diameter2(root.left);
        TreeInfo right=diameter2(root.right);

        int myheight=Math.max(left.ht,right.ht)+1;

        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht+1;

        int mydiam=Math.max(diam3,Math.max(diam1, diam2));

        TreeInfo myInfo =new TreeInfo(myheight, mydiam);
        return myInfo;
    }
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // preOrder(root);
        // postOrder(root);
        // inOrder(root);
        // levelOrder(root);
    //    System.out.println(countNode(root));
    // System.out.println(sumOfNode(root));
    // System.out.println(height(root));
    // System.out.println(diameter(root));
    System.out.println(diameter2(root).diam);
    }
}
