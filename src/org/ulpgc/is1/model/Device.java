package org.ulpgc.is1.model;

import java.util.*;

public class Device {
    public String serialNumber;
    public DeviceType type;
    public Customer owner;
    public List<Service> deviceServices;

    public Device(String serialNumber, DeviceType deviceType, Customer owner) {
        this.serialNumber = serialNumber;
        this.type = deviceType;
        this.owner = owner;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void addDeviceService(Service service) {
        if (deviceServices == null) {
            deviceServices = new ArrayList<>();
        }
        deviceServices.add(service);
    }
    public List<Service> getDeviceServices() {
        return deviceServices;
    }


}
