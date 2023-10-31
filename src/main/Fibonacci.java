/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F2(N));
    }

    public static long F2(int N) {
        long m = 0L;
        long n = 1L;
        long t = 0L;

        for (int i = 1; i < N; i++) {
            t = m + n;
            m = n;
            n = t;
        }
        return N == 0 ? 0L : n;
    }
}