package org.ulpgc.is1.model;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Service {

    // Atributos de la clase
    private static int NEXT_ID = 0;
    private final int id;
    private ServiceType type;
    private String description;

    // Atributos de las relaciones
    private Device device;
    private Budget budget;
    private Payment payment;
    private List<Employee> technicians;

    public Service(ServiceType type, String description, Device device, Budget budget) {
        this.id = ++NEXT_ID;
        this.type = type;
        this.description = description;
        this.device = device;
        this.budget = budget;
        this.payment = null; // No hay pago al principio
        this.technicians = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getDevice() {
        return device;
    }

    public Budget getBudget() {
        return budget;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<Employee> getTechnicians() {
        return technicians;
    }

    public void addTechnicians(Employee technician) {
        if (!technicians.contains(technician)) {
            technicians.add(technician);
        }
    }

    public void pay(Payment payment) {
        if (this.payment == null) {
            this.payment = payment;
            System.out.println("El servicio ha sido pagado correctamente");
        } else {
            System.out.println("El servicio ha sido pagado anteriormente.");
        }
    }

    //por si lo llegamos necesitar
    //public boolean isPaid() {
    //    return this.payment != null;
    //}

    @Override
    public String toString() {
        return ""; //modificar
    }
}
