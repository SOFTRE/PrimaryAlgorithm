package com.xxM.demo03;

class Link {
    //不想让内部类产生实例化对象，即只想内部类被外部类使用。
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode() {
            Link.this.retData[Link.this.foot++] = this.data;
            if (this.next == null) {
                return;
            } else {
                this.next.toArrayNode();
            }
        }

        public Object getDataNode(int index) {
            if (Link.this.foot++ == index) {
                return this.data;
            } else if (this.next == null) {
                return null;
            } else {
                return this.next.getDataNode(index);
            }
        }

        public void setDataNode(int index, Object data) {
            if (Link.this.foot++ == index) {
                this.data = data;
            } else {
                this.next.setDataNode(index, data);
            }
        }

        public boolean containsNode(Object data) {
            if (this.data.equals(data)) {
                return true;
            } else if (this.next == null) {
                return false;
            } else {
                return this.next.containsNode(data);
            }
        }

        public void removeNode(Node previous, Object data) {
            if (this.data.equals(data)) {
                previous.next = this.next;
            } else if (this.next == null) {
                return;
            } else {
                this.next.removeNode(this, data);
            }
        }
    }

    private Object[] retData;
    private int foot;
    private Node root;
    private int count;

    public void add(Object data) {
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public int getSize() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0 && this.root == null;
    }

    public Object[] toArray() {
        if (this.root == null) {
            return null;
        }
        this.retData = new Object[this.count];
        this.foot = 0;
        this.root.toArrayNode();
        return this.retData;
    }

    public boolean contains(Object data) {
        if (this.count == 0) {
            return false;
        }
        return this.root.containsNode(data);
    }

    public Object getData(int index) {
        if (index > this.count) {
            return null;
        }
        this.foot = 0;
        if (this.root == null) {
            return null;
        } else {
            return this.root.getDataNode(index);
        }
    }

    public void setData(int index, Object data) {
        if (index > this.count) {
            return;
        }
        this.foot = 0;
        this.root.setDataNode(index, data);
    }

    public void remove(Object data) {
        if (this.contains(data)) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;
            } else if (this.root.next == null) {
                return;
            } else {
                this.root.next.removeNode(this.root, data);
            }
        }
        this.count--;
    }
}

/**
 * @Author Mr Liu
 */
public class Linked {
    public static void main(String[] args) {
        Link link = new Link();
        System.out.println(link.getSize() + "==" + link.isEmpty());
        link.add("idud");
        link.add("hello");
        link.add(4324);
        link.add(43e24);
        link.add(434);
        link.add(4325);
        link.add(4327);
        link.add(4326);
        link.add(4328);
        link.add(4329);
        link.add("world");
        link.remove(4328);
        link.setData(1, "hello1");
        Object[] result = link.toArray();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(link.getSize() + "=" + link.isEmpty());
        System.out.println(link.contains("world"));
        System.out.println(link.getData(1));
    }
}
