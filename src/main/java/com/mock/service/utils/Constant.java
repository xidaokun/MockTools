package com.mock.service.utils;

import java.io.File;

public class Constant {
    public static final String OS_NAME = System.getProperty("os.name");

    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final String USER_HOME = System.getProperty("user.home");

    public static final String CONFIG_HOME = USER_HOME + File.separator + ".configs" + File.separator;

    public static final String LOG_HOME = USER_HOME + File.separator + ".logs" + File.separator;


}
