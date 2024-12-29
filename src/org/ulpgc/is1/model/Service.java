package org.ulpgc.is1.model;
import java.util.*;

public class Service {

    private static int NEXT_ID = 0;
    private final int id;
    private ServiceType type;
    private String description;
    private Device device;
    private Payment payment;
    private Budget budget;
    private List<Employee> Technicians;

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    public Device getDevice() {
        return device;
    }

    public Service(ServiceType type, String description) {
        this.id = NEXT_ID;
        this.type = type;
        this.description = description;
        NEXT_ID++;
    }

    public void pay(Date date,int amount) {
        payment = new Payment(date, amount);
    }

    public void addTechnician(Employee technician) {
        if (Technicians == null) {
            Technicians = new ArrayList<Employee>();
        }
        Technicians.add(technician);
    }
    public List<Employee> getTechnicians() {
        return Technicians;
    }
}
