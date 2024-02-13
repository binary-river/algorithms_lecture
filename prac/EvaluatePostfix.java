/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.main.LinkStack;

public class EvaluatePostfix {

    public static String evaluateExpression(String expr) {
        LinkStack<String> operands = new LinkStack<>();

        String[] sArr = expr.split(" ");
        for (String s : sArr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int operand2 = Integer.parseInt(operands.pop());
                int operand1 = Integer.parseInt(operands.pop());

                int r = 0;
                switch (s) {
                    case "+":
                        r = operand1 + operand2;
                        break;
                    case "-":
                        r = operand1 - operand2;
                        break;
                    case "*":
                        r = operand1 * operand2;
                        break;
                    case "/":
                        r = operand2 / operand1;
                }
                operands.push(String.valueOf(r));
            }
            else {
                operands.push(s);
            }
        }

        return operands.pop();

    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String expr = StdIn.readLine();
            StdOut.println(EvaluatePostfix.evaluateExpression(InfixToPostfix.filter(expr)));
        }
    }
}

//( ( ( 1 + 2 ) * ( 3 + 4 ) ) * 2 )
//( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )