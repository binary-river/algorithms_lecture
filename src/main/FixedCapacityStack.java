/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        // resize array to prevent overflow
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        // resize array to prevent waste of memory
        if (N > 0 && N == a.length / 4) resize(a.length / 2);

        return item;
    }

    // resize
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
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

    // test code
    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<>(1);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                StdOut.println(s.pop());
            }
        }
        StdOut.println("( " + s.size() + " left on stack )");

        for (String str : s) {
            StdOut.println(" : " + str + "");
        }
    }
}
