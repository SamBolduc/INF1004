package ca.uqtr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter infix : ");
            System.out.flush();

            input = getString();
            if (input.equals(""))
                break;

            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            System.out.println("Postfix is : " + output + "\n");

            if (output != "Erreur") {
                ParsePost parser = new ParsePost(output);
                double eval = parser.doParse();
                if (Double.isNaN(eval) || Double.isInfinite(eval)) {
                    System.out.println("Erreur");
                } else System.out.println("Evaluation is : " + eval + "\n");
            } else System.out.println("Erreur");
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
