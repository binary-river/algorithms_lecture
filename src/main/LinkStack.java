/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkStack<Item> {
    private int N;
    private Node first;

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (N == 0) return null;

        Node r = first;
        first = first.next;
        N--;
        return r.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


    private class Node {
        Item item;
        Node next;
    }

    public static void main(String[] args) {
        LinkStack<String> s = new LinkStack<>();
        while (!StdIn.isEmpty()) {
            String w = StdIn.readString();
            if (!w.equals("-")) {
                s.push(w);
            }
            else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println(" ( " + s.size() + " left on stack )");
    }
}
