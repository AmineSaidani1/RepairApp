package org.ulpgc.is1.model;
import java.util.*;

public class Phone {
    private String number;

    public Phone(String number) {setNumber(number);}

    public String getNumber() {return number;}

    public void setNumber(String number) {
        if (isValid(number)) {
            this.number = number;
        } else {
            System.out.println("invalid number");
        }
    }

    private boolean isValid(String number) {
        // Valida un número español (+34, opcional) y mira si el nº empieza por 6 o 7 y tiene 9 números.
        return number != null && number.matches("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Phone phone = (Phone) obj;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number;
    }
}
