package com.example.server_management_application.model;

public class Server {
    private int id;
    private String name;
    private int freeMemory;
    private boolean active;

    public Server(){}

    public Server(int id, String name, int freeMemory, boolean active) {
        this.id = id;
        this.name = name;
        this.freeMemory = freeMemory;
        this.active = active;
    }

    public void cloneServer(Server server) {
        this.id = server.id;
        this.name = server.name;
        this.freeMemory = server.freeMemory;
        this.active = server.active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    public boolean isActive() {
        return active;
    }

}
