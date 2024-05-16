package com.mock.service.view.vehicle;

import com.mock.service.push.SocketClient;
import com.mock.service.view.FixedHeightPanel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class VehicleCtl {

    public JPanel getBorder(int row, int col, String title) {
        JPanel panel = new FixedHeightPanel(100);
        panel.setLayout(new GridLayout(row, col));
        panel.setBorder(new CompoundBorder(getTitleBorder(title, 3), new EmptyBorder(0, 30, 0, 10)));

        return panel;

    }

    private TitledBorder getTitleBorder(String title, int thickness) {
        TitledBorder border = new TitledBorder(title);
        Border stypeBorder = BorderFactory.createLineBorder(Color.GRAY, thickness, false);
        border.setBorder(stypeBorder);
        return border;
    }

    public JPanel getSwitchView(String text, SwitchListener listener) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(new CompoundBorder(getTitleBorder(text, 1), new EmptyBorder(10, 20, 10, 20)));
//        panel.add(new JLabel(text));
        JRadioButton open = new JRadioButton("开");
        open.setSelected(true);
        JRadioButton close = new JRadioButton("关");
        ButtonGroup group = new ButtonGroup();
        group.add(open);
        group.add(close);

        open.addActionListener(e -> {
            if(null != listener) {
                listener.onSwitch(true);
            }
        });

        close.addActionListener(e -> {
            if(null != listener) {
                listener.onSwitch(false);
            }
        });


        panel.add(open);
        panel.add(close);
        return panel;
    }

    public JPanel getSliderView(String text, int max, int major, int minor,PositionListener listener) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(new CompoundBorder(getTitleBorder(text, 1), new EmptyBorder(10, 20, 10, 20)));

        JSlider slider = new JSlider(0, max);
        slider.setValue(0);
        slider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                if(null != listener) {
                    listener.onPosition(source.getValue());
                }
            }
        });
        slider.setMajorTickSpacing(major);
        slider.setMinorTickSpacing(minor);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel.add(slider);
        return panel;
    }

    public void startPush(SocketListener listener) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    SocketClient server = new SocketClient();
                    server.sendMessage("Hello");
                    if(null != listener) {
                        listener.connected(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if(null != listener) {
                        listener.connected(false);
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    public interface SocketListener {
        void connected(boolean isConnected);
    }

    public interface SwitchListener {
        void onSwitch(boolean isOpen);
    }

    public interface PositionListener {
        void onPosition(int position);
    }


}
