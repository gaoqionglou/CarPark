package com.example.parkapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import java.lang.ref.WeakReference;

public abstract class BaseActivity extends AppCompatActivity {

    private BasePopupView msgPopup;
    /***当前Activity的弱引用，防止内存泄露**/
    private WeakReference<Activity> mContextWR = null;

    public void showLoading(String msg) {
        showLoading(msg, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContextWR = new WeakReference<Activity>(this);
        // 初始化参数
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    protected Activity getContext() {
        if (null != mContextWR) {
            return mContextWR.get();
        } else {
            return null;
        }
    }

    public void showLoading() {
        showLoading("正在加载...", true);
    }

    public void showLoading(String msg, boolean cancel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (msgPopup != null && msgPopup.isShow()) {
                    msgPopup.dismiss();
                }
                msgPopup = new XPopup.Builder(getContext()).dismissOnTouchOutside(cancel).dismissOnBackPressed(cancel).asLoading(msg).show();
            }
        });

    }

    public void dismissPopup() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (msgPopup != null && msgPopup.isShow()) {
                    msgPopup.dismiss();
                }
            }
        });

    }

    public void showSuccess(String string) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               if (msgPopup != null && msgPopup.isShow()) {
                   msgPopup.dismiss();
               }
               msgPopup = new XPopup.Builder(getContext())
                       .asConfirm("操作成功", string, new OnConfirmListener() {
                           @Override
                           public void onConfirm() {

                           }
                       }).show();
           }
       });
    }

    public void showError(String string) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               if (msgPopup != null && msgPopup.isShow()) {
                   msgPopup.dismiss();
               }
               msgPopup = new XPopup.Builder(getContext())
                       .asConfirm("错误", string, new OnConfirmListener() {
                           @Override
                           public void onConfirm() {

                           }
                       }).show();
           }
       });
    }

}
