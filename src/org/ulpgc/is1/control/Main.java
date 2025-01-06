package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear el ServiceManager
        ServiceManager manager = new ServiceManager();

        // Añadir Cliente
        Phone phone = new Phone("628112233");
        manager.addCustomer("Antonio", "García González", phone);
        Customer customer = manager.getCustomer(phone);

        // Añadir Técnicos
        manager.addTechnician(1, "Antonio", "Garcia González");
        manager.addTechnician(2, "José", "Rodríguez Pérez");
        Employee technician1 = manager.getTechnician(1);
        Employee technician2 = manager.getTechnician(2);

        // Añadir Dispositivo
        manager.addDevice("1234-5678", DeviceType.Tablet, customer);
        Device device = manager.getDevice("1234-5678");

        // Crear Servicio
        List<Employee> managers = new ArrayList<>();
        managers.add(technician2); // José Rodríguez Pérez como gestor del presupuesto

        manager.service(
                ServiceType.Repair,
                "Arreglo del portátil",
                "1234-5678",
                DeviceType.Tablet,
                "Antonio",
                "García González",
                phone,
                LocalDate.of(2024, 12, 22),
                100,
                managers
        );

        // Recuperar el servicio y añadir pago
        List<Service> services = manager.getDeviceServiceList("1234-5678");
        if (services != null && !services.isEmpty()) {
            Service service = services.get(0);
            manager.payService(service, LocalDate.of(2024, 12, 22), 100);

            // Añadir tareas al servicio
            service.addTechnicians(1, "Antonio", "Garcia González");
            service.addTechnicians(2, "José", "Rodríguez Pérez");

            Work task1 = new Work(service, technician1, 2, "Desmontaje");
            Work task2 = new Work(service, technician2, 5, "Reparación y montaje");

            // Mostrar la información
            System.out.println("***********************************************************");
            System.out.println(customer);
            System.out.println("***********************************************************");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Servicio (ref. " + service.getId() + ")");
            System.out.println("--------------------------------------------------------------");
            System.out.println(service);
            System.out.println(device);
            System.out.println(service.getBudget());
            System.out.println("--------------------------------------------------------------");
            System.out.println("Tareas realizadas en el servicio");
            System.out.println("--------------------------------------------------------------");
            System.out.println(task1);
            System.out.println(task2);
        } else {
            System.out.println("No se encontraron servicios para el dispositivo.");
        }
    }
}
