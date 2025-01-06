package org.ulpgc.is1.model;
import java.time.LocalDate;
import java.util.*;

public class Service {
    private static int NEXT_ID = 0;
    private final int id;
    private ServiceType type;
    private String description;
    private Payment payment;
    private Budget budget;
    private Device device;
    private List<Employee> technicians;

    public Service(ServiceType type,
                   String description,
                   String serialNumber,
                   DeviceType deviceType,
                   String name,
                   String surname,
                   Phone phone,
                   LocalDate date,
                   int amount,
                   List<Employee> manager) {
        this.budget = new Budget(date, amount, manager);
        Customer owner = new Customer(name, surname, phone);
        this.device = new Device(serialNumber, deviceType, owner);
        this.id = ++NEXT_ID;
        this.type = type;
        this.description = description;
        this.payment = null; // No hay pago al principio
        this.technicians = new ArrayList<>();
    }

    public int getId() {return id;}

    public ServiceType getType() {return type;}

    public void setType(ServiceType type) {this.type = type;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Device getDevice() {return device;}

    public void setDevice(Device device) {this.device = device;}

    public Budget getBudget() {return budget;}

    public void setBudget(Budget budget) {this.budget = budget;}

    public Payment getPayment() {return payment;}

    public List<Employee> getTechnicians() {return technicians;}

    public void addTechnicians(int number, String name, String surname) {
        Employee technician = new Employee(number, name, surname);
        if (!technicians.contains(technician)) {
            technicians.add(technician);
        } else {
        System.out.println("Technician is already working in this service.");}
    }

    public void pay(LocalDate date, int amount) {
        Payment payment = new Payment(date, amount);
        if (payment.getAmount() < budget.getAmount()) {
            System.out.println("Payment < Budget");
            return;
        }
        this.payment = payment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("*) Datos del servicio:\n");
        sb.append("   |- Ref.: ").append(id).append("\n");
        sb.append("   |- Descripción: ").append(description).append("\n");
        sb.append("   |- Tipo: ").append(type).append("\n");
        sb.append("   |- Información del pago: ").append(payment);
        return sb.toString();
    }
}