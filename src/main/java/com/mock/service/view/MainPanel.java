package com.mock.service.view;

import com.intellij.uiDesigner.core.GridConstraints;

import java.awt.*;

public class MainPanel extends BasePanel {

    public static MainPanel create() {
        return new MainPanel();
    }

    private MainPanel() {
        add(TitleBar.create(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
    }



}
