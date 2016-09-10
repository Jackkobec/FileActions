package com.jss.node_actions;

/**
 * Use recursion where it is possible
 */
public interface NodeUtils {


    void addToTail(Node first, Object val);

    Node addToHead(Node chain, Object val);


    public  String toString(Node head);

    public  String toStringR(Node head);

    Node createNode(Object... mas);

    Node createNodeR(Object... mas);

    int count(Node chain);

    Node remove(Node chain, Object val);

    Object[] toArray(Node chain) throws NodeUtilsImpl.IncorrectChainException;

    //reverse using loop
    Node reverse(Node curr) throws NodeUtilsImpl.IncorrectChainException;

    public Node reverse2(Node curr) throws NodeUtilsImpl.IncorrectChainException;

    //reverse usin recursion
    Node reverse(Node curr, Node next, Node prev) throws NodeUtilsImpl.IncorrectChainException;




}
