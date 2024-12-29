package org.ulpgc.is1.model;

import java.util.*;

public class Device {
    public String serialNumber;
    public DeviceType deviceType;
    public Customer owner;
    public List<Service> deviceServices;

    public Device(String serialNumber, DeviceType deviceType, Customer owner) {
        this.serialNumber = serialNumber;
        this.deviceType = deviceType;
        this.owner = owner;
    }

    public String getSerialNumber() {
        return serialNumber;
    }


}
