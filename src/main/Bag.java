/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public void remove() {
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {

        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            bag.add(str);
        }

        // for (String str : bag) {
        //     StdOut.print(str + " ");
        // }

        for (Iterator iter = bag.iterator(); iter.hasNext(); ) {
            StdOut.print(iter.next() + " ");
        }

        StdOut.print(" ( " + bag.size() + " left in bag )");
    }
}
