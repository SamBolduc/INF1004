package ca.uqtr;

public class StackDouble {

    private int maxSize;
    private double[] stackArray;
    private int top;

    public StackDouble(int s) {
        this.maxSize = s;
        this.stackArray = new double[maxSize];
        this.top = -1;
    }

    public void push(double j) {
        this.stackArray[++this.top] = j;
    }

    public double pop() {
        return this.stackArray[this.top--];
    }

    public double peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int size() {
        return this.top + 1;
    }

    public double peekN(int n) {
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
