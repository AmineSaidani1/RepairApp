package org.ulpgc.is1.model;
import java.util.*;

public class Device {
    private String serialNumber;
    private DeviceType type;
    private Customer owner;
    private List<Service> deviceServices;

    public Device(String serialNumber, DeviceType deviceType, Customer owner) {
        this.serialNumber = serialNumber;
        this.type = deviceType;
        this.owner = owner;
    }

    public String getSerialNumber() {return serialNumber;}

    public DeviceType getType() {return type;}

    protected void addDeviceService(Service service) {
        if (deviceServices == null) {
            deviceServices = new ArrayList<>();
        }
        deviceServices.add(service);
    }
    protected List<Service> getDeviceServices() {
        return deviceServices;
    }


}
