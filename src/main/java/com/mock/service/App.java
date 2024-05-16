package com.mock.service;

import com.mock.service.view.MainFrame;

public class App {


    public static void main(String[] args) {
        // Mac适配
        InitCtl initCtl = new InitCtl();
        initCtl.initTheme();
        MainFrame.of().init();
//        initCtl.initFont();
    }

}
