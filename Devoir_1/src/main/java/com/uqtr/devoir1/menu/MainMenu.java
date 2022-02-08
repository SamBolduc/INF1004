package com.uqtr.devoir1.menu;

import com.uqtr.devoir1.action.LeaveAction;
import com.uqtr.devoir1.error.InvalidOptionError;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(TextIO textIO, TextTerminal<?> terminal) {
        super(textIO, terminal);
    }

    @Override
    public void show() {
        List<String> menu = new ArrayList<String>();
        menu.add("0 - Quitter.");
        menu.add("1 - Autre option.");
        menu.add("");
        menu.add("Veuillez choisir une option:");

        while (true) {
            int action = this.getTextIO().newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(0).withMaxVal(menu.size() - 2).read(menu);

            switch (action) {
                case 0:
                    new LeaveAction(this).execute();
                    break;
                case 1:
                    new LeaveAction(this).execute();
                    break;
            }
        }
    }
}