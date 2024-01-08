/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestPointGenerator {

    public static void main(String[] args) {

        StdOut.print("Input trials : ");
        int t = StdIn.readInt();

        PointGenerator pg = new PointGenerator(t);

        StdOut.println(pg.getClosestDistance());
    }
}
