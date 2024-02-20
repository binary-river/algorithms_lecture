/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ZeroByThree {

    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {

            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                        break;
                    }
                }
            }

            // if (i % 100 == 0) {
            //     StdOut.println("count : " + cnt);
            // }
        }
        return cnt;
    }

    public static int countFast(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-(a[i] + a[j]), a) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);

        Stopwatch w1 = new Stopwatch();
        StdOut.println("Fast cnt : " + ZeroByThree.countFast(a) + ", time : " + w1.elapsedTime());

        Stopwatch w2 = new Stopwatch();
        StdOut.println("Slow cnt : " + ZeroByThree.count(a) + ", time : " + w2.elapsedTime());
    }
}
