/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {

    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    // public int find(int p) {
    //     return id[p];
    // }

    // find root value, instead of just a value of indexed array
    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

    // public void union(int p, int q) {
    //     int pID = id[p];
    //     int qID = id[q];
    //
    //     if (pID == qID) return;
    //
    //     for (int i = 0; i < id.length; i++) {
    //         if (id[i] == pID) id[i] = qID;
    //     }
    //     count--;
    // }

    public static void main(String[] args) {

        Stopwatch watch = new Stopwatch();
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            // if (uf.connected(p, q)) continue;
            uf.union(p, q);
            // StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println("time : " + watch.elapsedTime());
    }
}
