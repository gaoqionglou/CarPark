package com.example.parkapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkapp.R;
import com.example.parkapp.model.AppDataManager;
import com.example.parkapp.model.AppDatabase;
import com.example.parkapp.model.ParkCarAuth;

import java.util.List;

public class CarAuthListAdapter extends RecyclerView.Adapter<CarAuthListAdapter.CarAuthListViewHolder> {


    private Context context;
    private List<ParkCarAuth> carAuths;

    public CarAuthListAdapter(Context context, List<ParkCarAuth> carAuths) {
        this.context = context;
        this.carAuths = carAuths;
    }


    public void setData(List<ParkCarAuth> carAuths) {
        this.carAuths = carAuths;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarAuthListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_auth_list_item, parent, false);
        return new CarAuthListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAuthListViewHolder holder, int position) {
        ParkCarAuth carAuth = carAuths.get(position);
        holder.carNumber.setText(carAuth.getNumber());
        holder.authBtn.setOnClickListener(v -> {
            AppDataManager.getInstance().getAppDatabase().parkCarAuthDao().deleteParkCarAuth(carAuth);
            carAuths.remove(carAuth);
            setData(carAuths);
        });
    }

    @Override
    public int getItemCount() {
        return carAuths != null ? carAuths.size() : 0;
    }

    static class CarAuthListViewHolder extends RecyclerView.ViewHolder {

        public TextView carNumber;
        public Button authBtn;

        public CarAuthListViewHolder(@NonNull View itemView) {
            super(itemView);
            carNumber = itemView.findViewById(R.id.tv_car_number);
            authBtn = itemView.findViewById(R.id.btn_car_auth);

        }
    }

}
