/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings implements Iterable<String> {

    String[] q = new String[1];
    int N;


    private void resize(int max) {
        String[] t = new String[max];
        for (int i = 0; i < N; i++) {
            t[i] = q[i];
        }
        q = t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(String item) {
        q[N++] = item;
        if (N == q.length) resize(q.length * 2);
    }

    public String dequeue() {
        String item = q[0];
        N--;
        this.rearrange();
        if (N > 0 && N < q.length / 4) resize(q.length / 2);
        return item;
    }

    private void rearrange() {
        for (int i = 0; i < q.length - 1; i++) {
            q[i] = q[i + 1];
        }
    }

    public Iterator<String> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<String> {

        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public String next() {
            return q[--i];
        }

        public void remove() {
            ;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings s = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String w = StdIn.readString();
            if (!w.equals("-")) {
                s.enqueue(w);
            }
            else if (!s.isEmpty()) {
                StdOut.print(s.dequeue() + " ");
            }
        }
        StdOut.println(" ( " + s.size() + " left on queue )");
    }
}
