package org.ulpgc.is1.model;

public class Work {
    private int timeSpent;
    private String description;
    private Service service;
    private Employee employee;

    public Work(Service service, Employee employee, int timeSpent, String description) {
        this.description = description;
        this.timeSpent = timeSpent;
        this.service = service;
        this.employee = employee;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
