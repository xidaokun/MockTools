package com.mock.service.view;

import javax.swing.*;
import java.awt.*;

public class FixedHeightPanel extends JPanel {

    private int height;

    public FixedHeightPanel(int height) {
        this.height = height;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.height = this.height;
        return size;
    }
}
