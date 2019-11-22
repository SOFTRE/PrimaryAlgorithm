package com.xxM.demo01;


class BinaryTree{
     private class Node{
         private Comparable data;
         private Node right;
         private Node left;
         public Node(Comparable data){
             this.data=data;
         }
         public void addNode(Node newNode){
             if (this.data.compareTo(newNode.data)>0){
                 if (this.left==null){
                     this.left=newNode;
                 }else {
                     this.left.addNode(newNode);
                 }
             }else {
                 if (this.right==null){
                     this.right=newNode;
                 }else {
                     this.right.addNode(newNode);
                 }
             }
         }
         public void toArrayNode(){
             if (this.left!=null){
                 this.left.toArrayNode();
             }
             BinaryTree.this.retData[BinaryTree.this.foot++]=this.data;
             if (this.right!=null){
                 this.right.toArrayNode();
             }
         }
     }
     private Node root;
     private int count;
     private int foot;
     private Object [] retData;
     public void add(Object data){
         if (data==null){
             return;
         }
         Node newNode=new Node((Comparable) data);
         if (this.root==null){
             this.root=newNode;
         }else {
             this.root.addNode(newNode);
         }
         this.count++;
     }
     public Object[] toArray(){
         if (this.root==null){
             return null;
         }
         this.foot=0;
         this.retData=new Object[this.count];
         this.root.toArrayNode();
         return this.retData;
     }
}
public class test {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(133);
        binaryTree.add(223);
        binaryTree.add(113);
        binaryTree.add(163);
        Object[] objects = binaryTree.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
