/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 */

package ca.uqtr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String output;

        while(true) {
            System.out.println("Enter infix : ");
            System.out.flush();

            for (String input : getString()) {
                if (input.equals(""))
                    break;

                InToPost theTrans = new InToPost(input);
                System.out.println();
                output = theTrans.doTrans();
                System.out.println("Postfix is : " + output);

                if (!output.equals("Error")) {
                    ParsePost parser = new ParsePost(output);
                    double eval = parser.doParse();
                    if (Double.isNaN(eval) || Double.isInfinite(eval)) {
                        System.out.println("Error");
                    } else System.out.println("Evaluation is : " + eval);
                } else System.out.println("Error");
            }
        }
    }

    public static List<String> getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        List<String> lines = new ArrayList<>();
        String s;
        do {
            s = br.readLine();
            lines.add(s);
        } while (s != null && !s.trim().equals(""));
        return lines;
    }
}
