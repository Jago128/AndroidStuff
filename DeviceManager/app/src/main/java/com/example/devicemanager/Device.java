package com.example.devicemanager;

public class Device {
    private final String name;
    private final String type;
    private final boolean bluetooth;
    private final boolean fiveG;

    public Device(String name, String type, boolean bluetooth, boolean fiveG) {
        this.name = name;
        this.type = type;
        this.bluetooth = bluetooth;
        this.fiveG = fiveG;
    }

    public String describe() {
        String desc = name +" ("+type+")";
        if (bluetooth) {
            desc += " + Bluetooth";
        }

        if (fiveG) {
            desc += " + 5G";
        }
        return desc;
    }
}
