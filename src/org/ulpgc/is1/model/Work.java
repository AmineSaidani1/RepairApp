package org.ulpgc.is1.model;

public class Work {
    private int timeSpent;
    private String description;
    private Service service;
    private Employee technician;

    public Work(Service service, Employee technician, int timeSpent, String description) {
        this.description = description;
        this.timeSpent = timeSpent;
        this.service = service;
        this.technician = technician;
    }

    public int getTimeSpent() {return timeSpent;}

    public void setTimeSpent(int timeSpent) {this.timeSpent = timeSpent;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Service getService() {return service;}

    public void setService(Service service) {this.service = service;}

    public Employee getTechnician() {return technician;}

    public void setTechnician(Employee technician) {this.technician = technician;}

    @Override
    public String toString() {
        return "Tarea { técnico = " + technician + ", concepto = '" + description + "', tiempo invertido = " + timeSpent + "}";
    }
}
