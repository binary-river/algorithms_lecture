/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N;


    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        Item r = a[--N];
        a[N] = null; // avoiding loitering
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return r;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

    }

    // test method
    public static void main(String[] args) {

        ResizingArrayStack<String> s = new ResizingArrayStack();

        while (!StdIn.isEmpty()) {
            String temp = StdIn.readString();
            if (!temp.equals("-")) {
                s.push(temp);
            }
            else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("");
        StdOut.println("remain words.. " + s.size());
        for (String word : s) {
            StdOut.print(word + " ");
        }
    }
}
