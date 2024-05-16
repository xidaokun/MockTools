package com.mock.service.view;

import javax.swing.*;

public class ScrollablePanel extends JScrollPane {

    public ScrollablePanel(JPanel panel) {
        super(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

}
