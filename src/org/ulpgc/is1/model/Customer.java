package org.ulpgc.is1.model;
import java.util.*;
public class Customer {
    private int id;
    public String name;
    public String surname;
    public Phone phone;
    private List<Device> customerDevices;

    public Customer(String name, String surname, Phone phone, int id) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.id = id;
    }


    public int getId() {
        return id;
    }
}
