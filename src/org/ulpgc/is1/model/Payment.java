package org.ulpgc.is1.model;
import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private int amount;

    public Payment(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Pago {fecha del pago = " + date + ", cantidad = " + amount + " euros}";
    }

}
