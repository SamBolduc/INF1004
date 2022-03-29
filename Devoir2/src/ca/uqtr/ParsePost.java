/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 */

package ca.uqtr;

public class ParsePost {

    private StackDouble theStack;
    private String input;

    public ParsePost(String s) {
        this.input = s;
    }

    public double doParse() {
        theStack = new StackDouble(20);
        String[] inputs = input.split(" ");
        double num1 = 0, num2, interAns = 0;
        for (String s : inputs) {
            if (isDigit(s)) {
                theStack.push(Double.parseDouble(s));
            } else {
                num2 = theStack.pop();
                if (!s.equals("$"))
                    num1 = theStack.pop();

                switch (s.charAt(0)) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0)
                            return Double.POSITIVE_INFINITY;
                        interAns = num1 / num2;
                        break;
                    case '$':
                        interAns = Math.sqrt(num2);
                        break;
                    default:
                        interAns = 0;
                }

                theStack.push(interAns);
            }
        }

        return theStack.pop();
    }

    private boolean isDigit(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
