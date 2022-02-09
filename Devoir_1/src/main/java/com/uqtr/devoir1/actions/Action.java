package com.uqtr.devoir1.actions;

import com.uqtr.devoir1.menus.Menu;

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