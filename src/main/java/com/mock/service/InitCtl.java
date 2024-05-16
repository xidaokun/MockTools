package com.mock.service;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mock.service.utils.SystemHelper;
import com.mock.service.utils.TextUtils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class InitCtl {
    private final Config config;
    public InitCtl() {
        config = Config.of();
    }


    public void initTheme() {
        try {
            String theme = config.getTheme();
            if(TextUtils.isEmpty(theme)) return;
            switch (theme) {
                case "系统默认":
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                case "Flat Light":
                    FlatLightLaf.setup();
                    break;
                case "Flat IntelliJ":
                    FlatIntelliJLaf.setup();
                    break;
                case "Flat Dark":
                    FlatDarkLaf.setup();
                    break;
                case "Dark purple":
                    FlatDarkPurpleIJTheme.setup();
                    break;
                case "IntelliJ Cyan":
                    FlatCyanLightIJTheme.setup();
                    break;
                case "IntelliJ Light":
                    FlatLightFlatIJTheme.setup();
                    break;
                case "Monocai":
                    FlatMonocaiIJTheme.setup();
                    break;
                case "Monokai Pro":
                    FlatMonokaiProIJTheme.setup();
                    UIManager.put("Button.arc", 5);
                    break;
                case "One Dark":
                    FlatOneDarkIJTheme.setup();
                    break;
                case "Gray":
                    FlatGrayIJTheme.setup();
                    break;
                case "High contrast":
                    FlatHighContrastIJTheme.setup();
                    break;
                case "GitHub Dark":
                    FlatGitHubDarkIJTheme.setup();
                    break;
                case "Xcode-Dark":
                    FlatXcodeDarkIJTheme.setup();
                    break;
                case "Vuesion":
                    FlatVuesionIJTheme.setup();
                    break;
                case "Flat macOS Light":
                    FlatMacLightLaf.setup();
                    break;
                case "Flat macOS Dark":
                    FlatMacDarkLaf.setup();
                    break;
                default:
                    FlatDarculaLaf.setup();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initFont() {
        int fontSize = config.getFontSize();
        if (SystemHelper.isMac() || (fontSize<=0)) {
            fontSize = 13;
            config.setFontSize(fontSize);
        }

        Font font = new Font(config.getFont(), Font.PLAIN, fontSize);
        FontUIResource fontUIResource = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontUIResource);
            }
        }
    }

}
