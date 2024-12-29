package org.ulpgc.is1.model;

import java.util.*;

public class ServiceManager {
    private List<Customer> customers;
    private List<Device> devices;
    private List<Employee> technicians;

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        else {
            System.out.println("Customer already exists");
        }
    }
    public Customer getCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    public void addDevice(Device device) {
        if (devices == null) {
            devices = new ArrayList<>();
        }
        if (!devices.contains(device)) {
            devices.add(device);
        }
        else {
            System.out.println("Device already exists");
        }
    }
    public Device getDevice(String serialNumber) {
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getSerialNumber().equals(serialNumber)) {
                return devices.get(i);
            }
        }
        return null;
    }
    public void addTechnician(Employee employee) {
        if (technicians == null) {
            technicians = new ArrayList<>();
        }
        if (!technicians.contains(employee)) {
            technicians.add(employee);
        }
        else {
            System.out.println("Employee already exists");
        }
    }
    public Employee getTechnician(int number) {
        for (int i = 0; i < technicians.size(); i++) {
            if (technicians.get(i).getNumber() == number) {
                return technicians.get(i);
            }
        }
        return null;
    }
    public void service() {

    }

    public void payService() {

    }

    public List<Service> getDeviceServiceList(String serialNumber) {
        List<Service> s = getDevice(serialNumber).deviceServices;
        if (s == null) {
            System.out.println("No device services found");
            return null;
        }
        return s;
    }


}
