/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {

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
        double prev = DoublingRatio.timeTrial(125);
        for (int N = 250; N < Integer.MAX_VALUE / 2; N += N) {
            double time = DoublingRatio.timeTrial(N);
            StdOut.printf("N: %d, time: %5.1f ", N, time);
            StdOut.printf("ratio: %5.1f\n", (time / prev));
            prev = time;
        }
    }
}
