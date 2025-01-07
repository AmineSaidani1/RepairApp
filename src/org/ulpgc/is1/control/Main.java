package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        // Se añaden los dos clientes
        manager.addCustomer("Antonio", "García González", "628112233");
        manager.addCustomer("Roberto", "Emilio Hernandez", "661112714");

        // Se crean tres dispositivos, los dos primeros para el primer cliente
        manager.addDevice("1234-5677", DeviceType.Smartphone, "628112233");
        manager.addDevice("1234-5679", DeviceType.Laptop, "628112233");
        manager.addDevice("1234-5678", DeviceType.Tablet, "661112714");

        // Se crean los dos empleados
        manager.addTechnician(1, "Antonio", "García González");
        manager.addTechnician(2, "José", "Rodríguez Pérez");

        // Se crea el servicio
        manager.service(
                ServiceType.Repair,
                "Arreglo del portátil",
                "1234-5679",
                DeviceType.Laptop,
                "628112233",
                LocalDate.of(2024, 12, 22),
                100,
                Arrays.asList(2)
        );

        // Realizar Pago
        List<Service> services = manager.getDeviceServiceList("1234-5679");
        if (services != null && !services.isEmpty()) {
            Service service = services.get(0);
            manager.payService(service, LocalDate.of(2024, 12, 22), 100);

            // Imprimir Información
            System.out.println("***********************************************************");
            System.out.println(service.getDevice().getOwner());
            System.out.println("***********************************************************");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Servicio (ref. " + service.getId() + ")");
            System.out.println("--------------------------------------------------------------");
            System.out.println(service);
            System.out.println(service.getDevice());
            System.out.println(service.getBudget());
            System.out.println("--------------------------------------------------------------");
            System.out.println("Tareas realizadas en el servicio");
            System.out.println("--------------------------------------------------------------");

            // Añadir Tareas
            manager.addWorkToService("1234-5679", 1, 2, "Desmontaje");
            manager.addWorkToService("1234-5679", 2, 5, "Reparación y montaje");
        } else {
            System.out.println("No se encontraron servicios para el dispositivo.");
        }
    }
}

