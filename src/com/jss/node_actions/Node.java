package com.jss.node_actions;

/**
 * Created by serhii on 05.09.16.
 */
public class Node {
    public final transient String testText = "NODE";
   // public int hasIndification;
    public Object value;
    public Node next;


    public Node() {
    }
    public Node(Object value) {
        this.value = value;

    }


//    public Node(int hasIndification) {
//        this.hasIndification = hasIndification;
//    }


    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "testText='" + testText + '\'' +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
