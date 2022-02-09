package com.uqtr.devoir1.actions;

import com.uqtr.devoir1.menus.Menu;

public class LeaveAction extends Action {
    public LeaveAction(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}