package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String setNumber() {
        return number;
    }

    public boolean isValid() {
        // Valida un número español (+34, opcional) y mira si el nº empieza por 6 o 7 y tiene 9 números.
        return number != null && number.matches("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}");
    }

    @Override
    public String toString() {
        return number;
    }
}
