package org.ulpgc.is1.model;
import java.util.*;

public class Device {
    private String serialNumber;
    private DeviceType type;
    private Customer owner;
    private List<Service> deviceServices = new ArrayList<>();

    public Device(String serialNumber, DeviceType deviceType, Customer owner) {
        this.serialNumber = serialNumber;
        this.type = deviceType;
        this.owner = owner;
    }

    public String getSerialNumber() {return serialNumber;}

    public DeviceType getType() {return type;}

    public Customer getOwner() {return owner;}

    public void addDeviceService(Service service) {deviceServices.add(service);}

    public List<Service> getDeviceServices() {return deviceServices;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("*) Datos del dispositivo:\n");
        sb.append("   |- Serial Number: ").append(serialNumber).append("\n");
        sb.append("   |- Tipo: ").append(type);
        return sb.toString();
    }
}
