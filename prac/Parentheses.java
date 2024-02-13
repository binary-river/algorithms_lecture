/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.main.LinkStack;

import java.util.HashMap;
import java.util.Map;

public class Parentheses {

    public static void main(String[] args) {

        /* make a client that reads in a text stream,
           then determine its parentheses are properly balanced
         */

        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('[', ']');
        parentheses.put('(', ')');
        parentheses.put('{', '}');

        LinkStack<Character> stack = new LinkStack<>();
        boolean result = true;

        while (!StdIn.isEmpty()) {
            Character c = StdIn.readChar();

            /* push parentheses open */
            if (parentheses.keySet().contains(c)) stack.push(c);

            /* pop parentheses open when meets parentheses close */
            if (parentheses.containsValue(c)) {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                
                Character t = stack.pop();
                if (parentheses.get(t) != c) {
                    result = false;
                    break;
                }
            }
        }

        StdOut.println("=======================");
        StdOut.println(result);
    }
}
