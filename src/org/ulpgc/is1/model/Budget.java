package org.ulpgc.is1.model;

import java.util.Date;

public class Budget {

    private Date date;

    private int amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Budget(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
