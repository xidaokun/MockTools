package com.mock.service.view;

import com.mock.service.Config;
import com.mock.service.Constants;
import com.mock.service.listeners.MyWindowListener;
import com.mock.service.res.ImageRes;
import com.mock.service.utils.SystemHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    public static MainFrame of() {
        return Holder.instance;
    }

    private static class Holder {
        private static MainFrame instance = new MainFrame();
    }

    private MainFrame() {
    }

    public void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (Config.of().isDefaultMaxWindow() || screenSize.getWidth() <= 1366) {
            // 低分辨率，窗口最大化
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        setTitle(Constants.APP_NAME);
        setName(Constants.APP_NAME);
        setIcon();
//        setJMenuBar(TopMenuBar.of());
        setMinimumSize(new Dimension(SystemHelper.getScreenSize().width/2, SystemHelper.getScreenSize().height/2));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setContentPane(MainPanel.create());

        addListeners();
    }

    private void setIcon() {
        List<Image> images = new ArrayList<>();
        images.add(ImageRes.IMAGE_LOGO_1024);
        images.add(ImageRes.IMAGE_LOGO_512);
        images.add(ImageRes.IMAGE_LOGO_256);
        images.add(ImageRes.IMAGE_LOGO_128);
        images.add(ImageRes.IMAGE_LOGO_64);
        images.add(ImageRes.IMAGE_LOGO_48);
        images.add(ImageRes.IMAGE_LOGO_32);
        images.add(ImageRes.IMAGE_LOGO_24);
        images.add(ImageRes.IMAGE_LOGO_16);
        setIconImages(images);
    }

    public void addListeners() {
        addWindowListener(new MyWindowListener(){
            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
                System.out.println("windowActivated");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("windowClosing");
                SystemHelper.shutDown();
            }

        });
    }

}
