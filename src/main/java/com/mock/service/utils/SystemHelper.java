package com.mock.service.utils;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.lang.reflect.Field;

public class SystemHelper {

    private static final String OS_NAME = System.getProperty("os.name");
    private static final String OS_ARCH = System.getProperty("os.arch");
    private static final String VM_VENDOR = System.getProperty("java.vm.vendor");
    public static void shutDown() {
        System.exit(0);
    }

    public static boolean isWindows() {
        return OS_NAME.contains("Windows");
    }
    public static boolean isMac() {
        return OS_NAME.contains("Mac");
    }

    public static boolean isLinux() {
        return OS_NAME.contains("Linux");
    }

    public static boolean isMacM1() {
        return OS_NAME.contains("Mac") && "aarch64".equals(OS_ARCH);
    }

    public static boolean isJBR() {
        return VM_VENDOR.contains("JetBrains");
    }

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static float getScreenScale() {
        int dpi = 96;

        try {
            dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        } catch (HeadlessException var2) {
        }

        float scale = 1.0F;
        if (dpi < 120) {
            scale = 1.0F;
        } else if (dpi < 144) {
            scale = 1.25F;
        } else if (dpi < 168) {
            scale = 1.5F;
        } else if (dpi < 192) {
            scale = 1.75F;
        } else {
            scale = 2.0F;
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        return scale;
    }

    public static void clearForm(Object object) {
        Class strClass = object.getClass();
        Field[] declaredFields = strClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (JTextComponent.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    ((JTextComponent) field.get(object)).setText("");
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
