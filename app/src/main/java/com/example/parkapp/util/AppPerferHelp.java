package com.example.parkapp.util;

import com.blankj.utilcode.util.SPUtils;

public class AppPerferHelp {
    private static AppPerferHelp instance;

    private AppPerferHelp() {
    }

    public static AppPerferHelp getInstance() {
        if (instance == null) {
            instance = new AppPerferHelp();
        }
        return instance;
    }


    public void setPay(float pay) {
        SPUtils.getInstance().put("PAY", pay);
    }

    public float getPay() {
        return SPUtils.getInstance().getFloat("PAY", 0.1f);
    }

    public void setSum(int sum) {
        SPUtils.getInstance().put("SUM", sum);
    }

    public int getSum() {
        return SPUtils.getInstance().getInt("SUM", 100);
    }
}