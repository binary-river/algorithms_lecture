/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkQueue<Item> {

    private int N;
    private Node first;
    private Node last;

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    // test client
    public static void main(String[] args) {
        LinkQueue<String> q = new LinkQueue<>();
        while (!StdIn.isEmpty()) {
            String t = StdIn.readString();
            if (!t.equals("-")) {
                q.enqueue(t);
            }
            else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println(" ( " + q.size() + " left on queque )");
    }
}
