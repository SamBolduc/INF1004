/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 */

package ca.uqtr;

public class InToPost {

    private StackString theStack;
    private String input;
    private String output = "";
    private int op = 0, cp = 0;

    public InToPost(String in) {
        this.input = in;
        int stackSize = this.input.length();
        this.theStack = new StackString(stackSize);
    }

    public String doTrans() {
        String[] inputs = this.split(this.input);

        for (String ch : inputs) {
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case "+":
                case "-":
                    gotOper(ch.charAt(0), 1);
                    break;
                case "*":
                case "/":
                    gotOper(ch.charAt(0), 2);
                    break;
                case "(":
                    op++;
                    theStack.push(ch.charAt(0));
                    break;
                case ")":
                    cp++;
                    if (cp > op)
                        return "Error";
                    gotParen();
                    break;
                case "$":
                    gotOper(ch.charAt(0), 3);
                    break;
                default:
                    output = output + ch + " ";
                    break;
            }
        }

        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + theStack.pop() + " ";
        }
        theStack.displayStack("End  ");
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;

                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else prec2 = 2;

                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else output = output + opTop + " ";
            }
        }

        theStack.push(opThis);
    }

    public void gotParen() {
        cp--;
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') {
                op--;
                break;
            }
            else output = output + chx + " ";
        }
    }

    private String[] split(String str) {
        return str
                .replaceAll("\\s+", "")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("*", " * ")
                .replace("/", " / ")
                .replace("$", " $ ")
                .replace("(", " ( ")
                .replace(")", " ) ")
                .replaceAll("\\s{2}", " ")
                .trim()
                .split(" ");
    }

}
