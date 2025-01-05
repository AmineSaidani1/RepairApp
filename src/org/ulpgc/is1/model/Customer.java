package org.ulpgc.is1.model;
import java.util.*;

public class Customer {
    private String name;
    private String surname;
    private Phone phone;
    private List<Device> customerDevices;

    public Customer(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    //aunque creo que los sets son inncecesarios, dejé el del teléfono y el nombre
    //por si algún cliente se quiere cambiar el teléfono o el nombre. El apellido no cambia.

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public Phone getPhone() {return phone;}

    public void setPhone(Phone phone) {this.phone = phone;}

}
