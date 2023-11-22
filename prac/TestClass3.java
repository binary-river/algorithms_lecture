/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;

public class TestClass3 {
    public static void main(String[] args) {

        String input = StdIn.readAll();
        String[] words = input.split("\\s+");

        for (String word : words) {
            System.out.println("words : " + word);
        }
    }
}
