package org.ulpgc.is1.model;
import java.time.LocalDate;
import java.util.*;

public class ServiceManager {
    private List<Customer> customers = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void addCustomer(String name, String surname, String phoneNumber) {
        Phone phone = new Phone(phoneNumber);
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

    public void addDevice(String serialNumber, DeviceType deviceType, String phoneNumber) {
        Customer owner = getCustomer(new Phone(phoneNumber));
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

    public void service(ServiceType type,
                        String description,
                        String serialNumber,
                        DeviceType deviceType,
                        String customerPhone,
                        LocalDate budgetDate,
                        int budgetAmount,
                        List<Integer> managerIds) {
        Customer customer = getCustomer(new Phone(customerPhone));
        if (customer == null) {
            System.out.println("Customer not found. Cannot create service.");
            return;
        }
        Device device = getDevice(serialNumber);
        if (device == null) {
            System.out.println("Device not found. Cannot create service.");
            return;
        }
        List<Employee> managers = new ArrayList<>();
        for (int id : managerIds) {
            Employee manager = getTechnician(id);
            if (manager != null) {
                managers.add(manager);
            }
        }
        Service service = new Service(type,
                description,
                serialNumber,
                deviceType,
                customer.getName(),
                customer.getSurname(),
                customer.getPhone(),
                budgetDate,
                budgetAmount,
                managers);
        device.getDeviceServices().add(service);
    }

    public void addWorkToService(String serialNumber, int technicianId, int timeSpent, String description) {
        List<Service> services = getDeviceServiceList(serialNumber);
        if (services != null && !services.isEmpty()) {
            Service service = services.get(0);
            Employee technician = getTechnician(technicianId);
            if (technician != null) {
                Work task = new Work(service, technician, timeSpent, description);
                System.out.println(task);
            } else {
                System.out.println("Technician not found.");
            }
        } else {
            System.out.println("No service found for the given serial number.");
        }
    }

    public void payService(Service service, LocalDate date, int amount) {
        service.pay(date, amount);
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
