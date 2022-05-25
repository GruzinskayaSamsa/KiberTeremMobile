package com.example.cyberteremmobile.models;

import java.lang.reflect.Array;

public class DeviceShortModel {

    int id;
    Array sensorTypes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Array getSensorTypes() {
        return sensorTypes;
    }

    public void setSensorTypes(Array sensorTypes) {
        this.sensorTypes = sensorTypes;
    }
}
