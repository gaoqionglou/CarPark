package com.example.parkapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.parkapp.adapter.CarAuthListAdapter;
import com.example.parkapp.base.BaseActivity;
import com.example.parkapp.common.Constants;
import com.example.parkapp.model.AppDataManager;
import com.example.parkapp.model.AppDatabase;
import com.example.parkapp.model.ParkCarAuth;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;

import java.util.List;

public class ParkCarAuthListActivity extends BaseActivity {
    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private CarAuthListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_auth_list);
        mToolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_car_auth_list);
        setSupportActionBar(mToolbar);

        adapter = new CarAuthListAdapter(this, null);
        DividerItemDecoration dec = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dec.setDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.divider_line_color)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(dec);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_car_auth_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add_auth_car:

                new XPopup.Builder(this).asInputConfirm("添加授权车辆", "输入车牌号码将车辆授权允许进入停车场", new OnInputConfirmListener() {
                    @Override
                    public void onConfirm(String text) {
                        if (RegexUtils.getMatches(Constants.CAR_REG, text).size() <= 0) {
                            ToastUtils.showShort("请填写正确车牌号码");
                            return;
                        }
                        if (AppDataManager.getInstance().getAppDatabase().parkCarAuthDao().isAuth(text)) {
                            ToastUtils.showShort("该车辆已授权，请换一个");
                            return;
                        }
                        ParkCarAuth parkCarAuth = new ParkCarAuth();
                        parkCarAuth.setNumber(text);
                        parkCarAuth.setAuthTime(TimeUtils.getNowMills());
                        AppDataManager.getInstance().getAppDatabase().parkCarAuthDao().insertParkCarAuth(parkCarAuth);
                        //添加之后刷新列表
                        if (adapter != null) {
                            List<ParkCarAuth> carAuths = AppDataManager.getInstance().getAppDatabase().parkCarAuthDao().getAllCarAuth();
                            adapter.setData(carAuths);
                        }
                        ToastUtils.showShort("添加车辆" + text + "授权成功");

                    }
                }).show();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<ParkCarAuth> carAuths = AppDataManager.getInstance().getAppDatabase().parkCarAuthDao().getAllCarAuth();
        if (adapter != null)
            adapter.setData(carAuths);

    }
}
