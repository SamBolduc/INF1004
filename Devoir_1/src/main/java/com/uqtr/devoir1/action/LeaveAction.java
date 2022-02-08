package com.uqtr.devoir1.action;

import com.uqtr.devoir1.menu.Menu;

public class LeaveAction extends Action {
    public LeaveAction(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}