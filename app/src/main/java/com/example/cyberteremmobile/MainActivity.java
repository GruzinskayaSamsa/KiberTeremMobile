package com.example.cyberteremmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.cyberteremmobile.adapters.DeviceShortModelAdapter;
import com.example.cyberteremmobile.models.DeviceShortModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView devicesList;
    static DeviceShortModelAdapter shortModelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private void setDevicesListRecycler(List<DeviceShortModel> deviceList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        devicesList = findViewById(R.id.devices_list);
        devicesList.setLayoutManager(layoutManager);

        shortModelAdapter = new DeviceShortModelAdapter(this, deviceList);
        devicesList.setAdapter(shortModelAdapter);
    }

}