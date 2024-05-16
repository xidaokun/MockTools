package com.mock.service.view.vehicle;

import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;

public class VehiclePanel extends JPanel {
    private VehicleCtl vehicleCtl = new VehicleCtl();
    private ServerSocket serverSocket;
    public static VehiclePanel create() {
        return new VehiclePanel();
    }

    private VehiclePanel(){
        setLayout(new GridLayout(6, 1));
        this.add(doorView());
        this.add(windowView());
        this.add(acView());
        this.add(seatHeatView());
        this.add(seatPositionView());
        this.add(lightView());

        vehicleCtl.startPush(isConnected -> {
            if(isConnected) {
                
            } else {
                System.out.println("Client disconnected");
            }
        });

    }

    private JPanel doorView() {
        JPanel doorView = vehicleCtl.getBorder(1, 6, "车门");

        JPanel lfPanel = vehicleCtl.getSwitchView("左前门", isOpen -> System.out.println("左前门" + (isOpen ? "开" : "关")));
        doorView.add(lfPanel);

        JPanel rfPanel = vehicleCtl.getSwitchView("右前门", isOpen -> System.out.println("右前门" + (isOpen ? "开" : "关")));
        doorView.add(rfPanel);

        JPanel lrPanel = vehicleCtl.getSwitchView("左后门", isOpen -> System.out.println("左后门" + (isOpen ? "开" : "关")));
        doorView.add(lrPanel);

        JPanel rrPanel = vehicleCtl.getSwitchView("右后门", isOpen -> System.out.println("右后门" + (isOpen ? "开" : "关")));
        doorView.add(rrPanel);

        return doorView;
    }

    private JPanel windowView() {
        JPanel windowView = vehicleCtl.getBorder(1, 6, "车窗");

        JPanel lfPanel = vehicleCtl.getSliderView("左前窗", 100, 10, 5, position -> System.out.println("左前窗" + position));
        windowView.add(lfPanel);

        JPanel rfPanel = vehicleCtl.getSliderView("右前窗", 100, 10, 5,position -> System.out.println("右前窗" + position));
        windowView.add(rfPanel);

        JPanel lrPanel = vehicleCtl.getSliderView("左后窗", 100, 10, 5,position -> System.out.println("左后窗" + position));
        windowView.add(lrPanel);

        JPanel rrPanel = vehicleCtl.getSliderView("右后窗", 100, 10, 5,position -> System.out.println("右后窗" + position));
        windowView.add(rrPanel);

        return windowView;
    }

    private JPanel acView() {
        JPanel acView = vehicleCtl.getBorder(1, 6, "空调");

        JPanel switchPanel = vehicleCtl.getSwitchView("空调开关", isOpen -> System.out.println("开关=" + (isOpen ? "开" : "关")));
        acView.add(switchPanel);

        JPanel levelPanel = vehicleCtl.getSliderView("空调等级", 4, 1, 1,position -> System.out.println("等级=" + position));
        acView.add(levelPanel);

        return acView;
    }

    private JPanel seatHeatView() {
        JPanel headView = vehicleCtl.getBorder(1, 6, "座椅加热");

        JPanel switchPanel = vehicleCtl.getSwitchView("加热开关", isOpen -> System.out.println("开关=" + (isOpen ? "开" : "关")));
        headView.add(switchPanel);

        JPanel levelPanel = vehicleCtl.getSliderView("加热等级", 4, 1, 1,position -> System.out.println("等级=" + position));
        headView.add(levelPanel);

        return headView;
    }

    private JPanel seatPositionView() {
        JPanel positionView = vehicleCtl.getBorder(1, 6, "座椅位置");

        JPanel aroundPanel = vehicleCtl.getSliderView("前后调节", 100, 10, 5,position -> System.out.println("等级=" + position));
        positionView.add(aroundPanel);

        JPanel highPanel = vehicleCtl.getSliderView("上下调节", 100, 10, 5,position -> System.out.println("等级=" + position));
        positionView.add(highPanel);

        return positionView;
    }

    private JPanel lightView() {
        JPanel lightView = vehicleCtl.getBorder(1, 6, "车灯");

        JPanel switchPanel = vehicleCtl.getSwitchView("车灯开关", isOpen -> System.out.println("开关=" + (isOpen ? "开" : "关")));
        lightView.add(switchPanel);

        JPanel levelPanel = vehicleCtl.getSliderView("车灯等级", 4, 1, 1,position -> System.out.println("等级=" + position));
        lightView.add(levelPanel);

        return lightView;
    }

}
