package com.mock.service.view;

import com.mock.service.listeners.MyMouseListener;
import com.mock.service.view.vehicle.VehiclePanel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Locale;

/**
 * TitleBar
 */
public class TitleBar extends JTabbedPane {

    public static TitleBar create() {
        return new TitleBar();
    }

    public TitleBar() {
        setDoubleBuffered(true);
        Font tabbedPaneFont = getFont(null, -1, -1, getFont());
        if (tabbedPaneFont != null) setFont(tabbedPaneFont);
        setTabLayoutPolicy(1);

        addTabs();
        addListeners();
    }

    private void addTabs() {
        addTab("Vehicle", new ScrollablePanel(VehiclePanel.create()));
        addTab("CPSP", CPSPPanel.create());
        addTab("Eco", EcoPanel.create());
        addTab("Interaction", InteractionPanel.create());
    }

    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    public void addListeners() {
        addMouseListener(new MyMouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    MainFrame mainFrame = MainFrame.of();
                    if (mainFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                        mainFrame.setExtendedState(JFrame.NORMAL);
                    } else {
                        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                }
            }
        });
    }
}
