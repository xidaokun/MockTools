package com.mock.service.view;

import javax.swing.*;

public class TopMenuBar extends JMenuBar {

    public static TopMenuBar of() {
        return new TopMenuBar();
    }

    public TopMenuBar() {
        JMenu editMenu = new JMenu();
        editMenu.setText("编辑");
        add(editMenu);

        JMenu windowMenu = new JMenu();
        windowMenu.setText("窗口");
        add(windowMenu);

        JMenu settingMenu = new JMenu();
        settingMenu.setText("设置");
        add(settingMenu);

        JMenu helpMenu = new JMenu();
        helpMenu.setText("帮助");
        add(helpMenu);
    }

}
