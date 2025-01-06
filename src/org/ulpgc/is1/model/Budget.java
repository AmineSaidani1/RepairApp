package org.ulpgc.is1.model;
import java.time.LocalDate;
import java.util.*;

public class Budget {
    private LocalDate date;
    private int amount;
    private List<Employee> manager;

    public Budget(LocalDate date, int amount, List<Employee> manager) {
        this.date = date;
        this.amount = amount;
        this.manager = manager; //Manager no es un solo employee porque pueden ser de 1 a muchos
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Employee> getManager() {
        return manager;
    }

    public void setManager(List<Employee> manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("*) Datos del presupuesto:\n");
        sb.append("   |- Gestionado por: ");
        for (int i = 0; i < manager.size(); i++) { //Itera sobre los empleados en la lista manager y concatena nombre y apellidos
            Employee employee = manager.get(i);
            sb.append(employee.getName()).append(" ").append(employee.getSurname());
            if (i < manager.size() - 1) {sb.append(", ");} //Añade una coma si hay más de un empleado
        }
        sb.append("\n");
        sb.append("   |- Fecha: ").append(date).append("\n");
        sb.append("   |- Total: ").append(amount);
        return sb.toString();
    }
}
