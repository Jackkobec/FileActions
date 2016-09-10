package com.jss.node_actions;

import java.util.Arrays;
/**
 * Node Actions
 *
 * @Autor   Jack
 * @Version 2.0
 * @email:  jackkobec@gmail.com
 * @Skype:  skypejs77
 */
public class NodeUtilsImpl implements NodeUtils {

    /**
     * addToTail
     *
     * @param first
     * @param val
     */
    @Override
    public void addToTail(Node first, Object val) {
        if (null == first.next) {
            first.next = new Node(val, null);
        } else {
            addToTail(first.next, val);
        }
    }

    /**
     * addToHead
     *
     * @param chain
     * @param val
     * @return
     */
    @Override
    public Node addToHead(Node chain, Object val) {
        if (null == chain.next) {
            return new Node(val, null);
        } else return new Node(val, chain);
    }

    /**
     * toString
     *
     * @param head
     * @return
     */
    @Override
    public String toString(Node head) {

        StringBuilder sb = new StringBuilder();
        Node lastPointer = head;

        while (lastPointer != null) {
            sb.append(lastPointer.value + "->");
            lastPointer = lastPointer.next;
        }
        return sb.toString();
    }

    /**
     * toStringR
     *
     * @param head
     * @return
     */
    @Override
    public String toStringR(Node head) {
        return head != null ?
                (head.value.toString() + "->" + toStringR(head.next)) : "";
    }

    /**
     * createNode
     *
     * @param mas
     * @return
     */
    @Override
    public Node createNode(Object... mas) {

        if (mas.length == 0) return null;
        // first empty Node
        // |null| <- headPointer
        Node headPointer = new Node(null, null);
        // Node lastPointer look at the headPointer
        // |null| <- headPointer <- lastPointer
        Node lastPointer = headPointer;
        // move through the
        int nodeCount = 0;

        for (Object obj : mas) {
            // new Node(obj, null)| <- lastPointer.next
            lastPointer.next = new Node(obj, null);
            // |null| <- headPointer <- |new Node(obj, null)| <- lastPointer
            lastPointer = lastPointer.next;
            nodeCount++;
        }
        System.out.println("Created Node count: " + nodeCount);
        return headPointer;
    }

    /**
     * createNodeR
     *
     * @param mas
     * @return
     */
    @Override
    public Node createNodeR(Object... mas) {

        if (mas.length == 0) return null;
        // if mas consist of more then 1 Object we create new Array for the next operations
        Object[] masReduced = new Object[mas.length - 1];
        // copy source Array from position 1 to the created Array on first position and created Array length
        System.arraycopy(mas, 1, masReduced, 0, masReduced.length);
        // call recursion with reduced Array
        return new Node(mas[0], createNodeR(masReduced));
    }

    /**
     * Alexandr Nagorniy method createNodeRA
     *
     * @param mas
     * @return
     */
    public Node createNodeRA(Object... mas) {
        if (mas == null || mas.length == 0) return null;

        return new Node(mas[0], createNodeR(Arrays.copyOfRange(mas, 1, mas.length)));
    }

    /**
     * count
     *
     * @param chain
     * @return
     */
    @Override
    public int count(Node chain) {
        if (null != chain) {
            return count(chain.next) + 1;
        }

        return 0;
    }

    /**
     * remove
     *
     * @param chain
     * @param val
     * @return
     */
    @Override
    public Node remove(Node chain, Object val) {
        if (chain.value == null) {
            return new Node();
        }

        if (chain.value == val && null != chain.next) {
            return new Node(chain.next.value, chain.next.next);

        } else if (chain.value == val && null == chain.next) {
            return new Node();
        }
        return null;
    }

    /**
     * toArray
     *
     * @param chain
     * @return
     * @throws IncorrectChainException
     */
    @Override
    public Object[] toArray(Node chain) throws IncorrectChainException {
        if (null == chain) {
            throw new IncorrectChainException("Incorrect chain!");
        }

        Node lastPointer = chain;
        Object[] arrObject = new Object[count(chain)];

        for (int i = 0; i < arrObject.length; ++i) {
            arrObject[i] = lastPointer.value;
            lastPointer = lastPointer.next;
        }

        return arrObject;
    }

    /**
     * Array tactic.
     *
     * @param curr
     * @return
     * @throws IncorrectChainException
     */
    @Override
    public Node reverse(Node curr) throws IncorrectChainException {
        if (null == curr) {
            throw new IncorrectChainException("Incorrect chain!");
        }

        Object[] lineArrey = toArray(curr);
        Object[] reversiveArray = new Object[lineArrey.length];

        for (int i = lineArrey.length - 1, j = 0; i >= 0
                && j < reversiveArray.length; i--, j++) {
            reversiveArray[j] = lineArrey[i];
        }
        return createNode(reversiveArray);
    }

    /**
     * reverse2
     *
     * @param curr
     * @return
     * @throws IncorrectChainException
     */
    @Override
    public Node reverse2(Node curr) throws IncorrectChainException {
        if (null == curr) {
            throw new IncorrectChainException("Incorrect chain!");
        }
        // |predidushiy = null| <- |curr|
        Node predidushiy = null;
        // |predidushiy = null| <- |curr| <- |sleduushiy = curr.next|
        Node sleduushiy = curr.next;

        while (sleduushiy != null) {
            // |predidushiy = curr.next| <- |curr| <- |sleduushiy = curr.next|
            curr.next = predidushiy;
            // |predidushiy = curr| <- |curr| <- |sleduushiy = curr.next|
            predidushiy = curr;
            // |predidushiy = curr| <- |curr = sleduushiy| <- |sleduushiy = curr.next|
            curr = sleduushiy;
            // |predidushiy = curr| <- |curr = sleduushiy| <- |sleduushiy = sleduushiy.next|
            sleduushiy = sleduushiy.next;
        }

        curr.next = predidushiy;

        return curr;
    }

    /**
     * reverse(Node curr, Node next, Node prev)
     *
     * @param curr
     * @param next
     * @param prev
     * @return
     * @throws IncorrectChainException
     */
    @Override
    public Node reverse(Node curr, Node next, Node prev) throws IncorrectChainException {
        if (null == curr) {
            throw new IncorrectChainException("Incorrect chain!");
        }
        if (null == next) {
            return curr;
        }
        Node chain = new Node(prev.value, new Node(curr.value, new Node(next.value)));
        System.out.println(toString(chain));


        return reverse(chain);
    }


    public class IncorrectChainException extends RuntimeException {
        public IncorrectChainException(String s) {
        }
    }
}
