package com.jss.node_actions;

import com.jss.fileactions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Стас on 08.09.2016.
 */
public class TestNodeActions {
    public static void main(String[] args) {
        NodeUtils nu = new NodeUtilsImpl();

        Node node1 = new Node();
        System.out.println(node1);

        User user = new User("22", "Vasa");
        User user2 = new User("23", "Peta");
        User user3 = new User("24", "Kola");
        User testUser = new User("777", "Test");

        // Test chain
        Node chain = nu.createNodeR(user, user2, user3);
        Node chain2 = nu.createNodeR(user, user2, user3);

        List<Node> nodeArr = new ArrayList<>();
        //Nodes in the ArrayList
        nodeArr.add(nu.createNode(user, user2, user3));
        //  listStrCorrectShow(nodeArr);


        System.out.println("Test createNode: ");
        System.out.println(nu.toString(nu.createNode(user, user2, user3)));
        System.out.println("========================================");

        System.out.println("Test createNodeR: ");
        System.out.println(nu.toString(nu.createNodeR(user, user2, user3)));
        System.out.println("========================================");

        System.out.println("Test count: ");
        System.out.println("Count of nodes in this chain: " + nu.count(nu.createNodeR(user, user2, user3)));
        System.out.println("========================================");

        System.out.println("Test addToTail: ");
        nu.addToTail(chain, testUser);
        System.out.println(nu.toString(chain));
        System.out.println("========================================");

        System.out.println("Test addToHead: ");
        System.out.println(nu.toString(nu.addToHead(chain, testUser)));
        System.out.println("========================================");

        System.out.println("Test remove: ");
        System.out.println(nu.toString(nu.remove(chain2, user)));
        System.out.println("========================================");

        chain2 = nu.createNodeR(user, user2, user3);
        System.out.println("Test toArray: ");
        listObjCorrectShow(nu.toArray(chain2));
        System.out.println("========================================");


        chain2 = nu.createNodeR(user, user2, user3);
        System.out.println("Test reverse: ");
        System.out.println(nu.toString(nu.reverse(chain2)));
        System.out.println("========================================");

        chain2 = nu.createNodeR(user, user2, user3);
        System.out.println("Test reverse2: ");
        System.out.println(nu.toString(nu.reverse2(chain2)));
        System.out.println("========================================");
    }


    public static <T> void listTCorrectShow(List<T> list) {
        for (T s : list) {
            System.out.println(s);
        }
    }

    public static void listObjCorrectShow(Object[] mas) {
        for (Object obj : mas) {
            System.out.println(obj);
        }
    }
}
