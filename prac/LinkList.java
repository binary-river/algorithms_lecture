/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkList<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }


    public void add(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = first;
        first = temp;
        N++;
    }

    public void delete(int k) {

        Node e0 = null;
        Node e1 = first;
        int rest = N - k;

        if (rest < 0) return;

        for (int i = 1; i < rest; i++) {
            e0 = e1;
            e1 = e1.next;
        }

        if (e0 == null) {
            first = e1.next;
        }
        else {
            e0.next = e1.next;
        }

    }

    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item> {

        private Node t = first;

        public boolean hasNext() {
            return t != null;
        }

        public Item next() {
            Item item = t.item;
            t = t.next;
            return item;
        }

        public void remove() {
            ;
        }
    }

    public static void main(String[] args) {
        LinkList<String> a = new LinkList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");

        for (String arg : a) {
            StdOut.print(arg + " ");
        }
        StdOut.println();

        a.delete(-1);

        for (String arg : a) {
            StdOut.print(arg + " ");
        }
        StdOut.println();

    }
}
