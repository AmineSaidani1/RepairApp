package org.ulpgc.is1.model;
import java.util.*;

public class ServiceManager {
    private List<Customer> customers = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void addCustomer(String name, String surname, Phone phone) {
        Customer customer = new Customer(name, surname, phone);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        else {
            System.out.println("Customer already exists");
        }
    }

    public Customer getCustomer(Phone phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        System.out.println("Customer does not exist");
        return null;
    }

    public void addDevice(String serialNumber, DeviceType deviceType, Customer owner) {
        Device device = new Device(serialNumber, deviceType, owner);
        if (!devices.contains(device)) {
            devices.add(device);
        }
        else {
            System.out.println("Device already exists");
        }
    }
    public Device getDevice(String serialNumber) {
        for (Device device : devices) {
            if (device.getSerialNumber().equals(serialNumber)) {
                return device;
            }
        }
        System.out.println("Device does not exist");
        return null;
    }

    public void addTechnician(int number, String name, String surname) {
        Employee employee = new Employee(number, name, surname);
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
        else {
            System.out.println("Employee already exists");
        }
    }
    public Employee getTechnician(int number) {
        for (Employee employee : employees) {
            if (employee.getNumber() == number) {
                return employee;
            }
        }
        System.out.println("Employee does not exist");
        return null;
    }

    public void service(Service service) {
        System.out.println("The service ID " + service.getId() + " has been registred.");
    }

    public void payService(Service service, Payment payment) {
        service.pay(payment);
    }

    public List<Service> getDeviceServiceList(String serialNumber) {
        for (Device device : devices) {
            if (device.getSerialNumber().equals(serialNumber)) {
                return device.getDeviceServices();
            }
        }
        System.out.println("Device not found");
        return null;
    }
}
