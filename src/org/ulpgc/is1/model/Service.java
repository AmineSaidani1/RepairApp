package org.ulpgc.is1.model;

public class Service {

    private static int NEXT_ID = 0;
    private final int id;

    private ServiceType type;

    private String description;

    public static int getNextId() {
        return NEXT_ID;
    }

    public static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Service(int id, ServiceType type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public pay(){


    }
}
