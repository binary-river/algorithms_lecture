/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class BagP<Item> implements Iterable<Item> {

    private int N;
    private Node first;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        N++;
    }

    public Iterator<Item> iterator() {
        return new IterItem();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class IterItem implements Iterator<Item> {

        private Node current = first;

        public void remove() {
            ;
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

        BagP<String> bagp = new BagP<>();

        // BagP<String>[] a = (BagP<String>[]) new BagP[20];

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            bagp.add(s);
        }

        for (String s : bagp) {
            StdOut.print(s + " ");
        }

        StdOut.println(" ( " + bagp.size() + " left in bag ) ");
    }
}
