package com.mock.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.Setting;
import com.mock.service.utils.Constant;
import com.mock.service.utils.SystemHelper;


public class Config {

    private final String configPath = Constant.CONFIG_HOME + "v1_0.config";
    private Setting setting;
    private static Config mInstance;


    public static Config of() {
        if(null == mInstance) {
            mInstance = new Config();
        }
        return mInstance;
    }

    private Config() {
        setting = new Setting(FileUtil.touch(configPath), CharsetUtil.CHARSET_UTF_8, false);
    }


    public String getTheme() {
        return setting.getStr("theme", "setting.appearance", "Flat macOS Dark");
    }


    public void setTheme(String theme) {
        setting.put("setting.appearance", "theme", theme);
    }

    public boolean isCloseToTray() {
        return setting.getBool("closeToTray", "setting.normal", true);
    }

    public String getFont() {
        if (SystemHelper.isLinux()) {
            return setting.getStr("font", "setting.appearance", "Noto Sans CJK HK");
        } else if (SystemHelper.isMac()) {
            return setting.getStr("font", "setting.appearance", "PingFang SC");
        } else {
            return setting.getStr("font", "setting.appearance", "微软雅黑");
        }
    }

    public void setFont(String font) {
        setting.put("setting.appearance", "font", font);
    }

    public int getFontSize() {
        return setting.getInt("fontSize", "setting.appearance", 12);
    }

    public void setFontSize(int fontSize) {
        setting.put("setting.appearance", "fontSize", String.valueOf(fontSize));
        setting.store(configPath);
    }

    public boolean isDefaultMaxWindow() {
        return setting.getBool("defaultMaxWindow", "setting.normal", true);
    }

}
