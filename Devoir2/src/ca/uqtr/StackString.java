package ca.uqtr;

public class StackString {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackString(int s) {
        this.maxSize = s;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j) {
        this.stackArray[++this.top] = j;
    }

    public char pop() {
        return this.stackArray[this.top--];
    }

    public char peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int size() {
        return this.top + 1;
    }

    public char peekN(int n) {
        return this.stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.peekN(i));
            System.out.print("  ");
        }
        System.out.println();
    }

}
