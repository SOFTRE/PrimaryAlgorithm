package com.xxM.demo03;

class BinaryTree {
    private class Node {
        private Comparable data;
        private Node left;
        private Node right;
        public Node(Comparable data) {
            this.data = data;
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
            //直到左边为空的时候取出数据。
            if (this.left!=null){
                this.left.toArrayNode();
            }
            BinaryTree.this.retData[BinaryTree.this.foot++]=this.data;
            if (this.right!=null){
                this.right.toArrayNode();
            }
            if (this.right==null){
                return;
            }
        }
    }
    private Object [] retData;
    private int foot;
    private Node root;
    private int count;
    public void add(Object data) {
        if (data == null) {
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
    public int getSize(){
        return this.count;
    }
    public boolean isEmpty(){
        return this.count==0&&this.root==null;
    }
    public Object[] toArray(){
        if (this.root==null){
            return null;
        }
        this.retData=new Object[this.count];
        this.foot=0;
        this.root.toArrayNode();
        return retData;
    }
}

/**
 * @Author Mr Liu
 */
public class TestForBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        System.out.println(binaryTree.getSize()+"="+binaryTree.isEmpty());
        binaryTree.add("fj");
        binaryTree.add("dd");
        binaryTree.add("dj");
        binaryTree.add("yd");
        binaryTree.add("nd");
        Object [] result=binaryTree.toArray();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(binaryTree.getSize()+"="+binaryTree.isEmpty());

    }
}
