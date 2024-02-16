/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

    public static double timeTrial(int N) {
        final int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ZeroByThree.count(a);

        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250; N <= 2500000; N += N) {

            // power laws
            double expectTime = 9.98 * Math.pow(10, -11) * Math.pow(N, 3);
            double time = timeTrial(N);
            double actualA = time / Math.pow(N, 3);
            StdOut.printf("%7d:: expect time: %5.1f, actual time: %5.1f, actual a: %e\n",
                          N, expectTime, time, actualA);
        }
    }
}
