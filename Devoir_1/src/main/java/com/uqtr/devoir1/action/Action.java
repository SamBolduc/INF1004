package com.uqtr.devoir1.action;

import com.uqtr.devoir1.menu.Menu;

public abstract class Action {

    private Menu menu;

    public Action(Menu menu) {
        this.menu = menu;
    }

    public abstract void execute();

    protected Menu getMenu() {
        return this.menu;
    }
}