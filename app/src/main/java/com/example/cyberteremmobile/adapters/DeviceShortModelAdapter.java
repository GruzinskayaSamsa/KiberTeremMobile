package com.example.cyberteremmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cyberteremmobile.MainActivity;
import com.example.cyberteremmobile.R;
import com.example.cyberteremmobile.models.DeviceShortModel;

import java.util.List;

public class DeviceShortModelAdapter extends RecyclerView.Adapter<DeviceShortModelAdapter.ShortDeviceModelViewHolder> {

    Context context;
    List<DeviceShortModel> devices;

    public DeviceShortModelAdapter(Context context, List<DeviceShortModel> deviceList) {
        this.context = context;
        this.devices = deviceList;
    }


    @NonNull
    @Override
    public ShortDeviceModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View availableDevices = LayoutInflater.from(context).
                inflate(R.layout.name_of_available_devices_fragment, parent, false);

        return new ShortDeviceModelViewHolder(availableDevices);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortDeviceModelViewHolder holder, int position) {

        holder.id.setText(devices.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public final static class ShortDeviceModelViewHolder extends RecyclerView.ViewHolder{

        TextView id;

        public ShortDeviceModelViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.device_id);
        }
    }
}
