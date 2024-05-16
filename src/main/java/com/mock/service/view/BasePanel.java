package com.mock.service.view;

import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {
    public BasePanel() {
        setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        setMaximumSize(new Dimension(-1, -1));
        setMinimumSize(new Dimension(-1, -1));
        setPreferredSize(new Dimension(-1, -1));
    }

}
