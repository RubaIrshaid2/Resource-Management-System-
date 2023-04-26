package com.example.server_management_application.model;
/**
 *The Server class represents a server entity in the server management application.
 */
public class Server {
    /**
     * the id of the server
     */
    private int id;
    /**
     * the name of the server.
     */
    private String name;
    /**
     * the amount of free memory on the server.
     */
    private int freeMemory;
    /**
     * whether the server is active or not.
     */
    private boolean active;

    /**
     * Constructs an empty Server object.
     */
    public Server(){}

    /**
     * Constructs a Server object with the specified id, name, free memory and active status.
     *
     * @param id the id of the server
     * @param name the name of the server
     * @param freeMemory the amount of free memory on the server
     * @param active the active status of the server
     */
    public Server(int id, String name, int freeMemory, boolean active) {
        this.id = id;
        this.name = name;
        this.freeMemory = freeMemory;
        this.active = active;
    }

    /**
     * Clones the properties of the specified server object to this server object.
     *
     * @param server the server object to clone
     */
    public void cloneServer(Server server) {
        this.id = server.id;
        this.name = server.name;
        this.freeMemory = server.freeMemory;
        this.active = server.active;
    }
    /**
     * Returns the id of the server.
     *
     * @return the id of the server
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the server.
     *
     * @return the name of the server
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the amount of free memory on the server.
     *
     * @return the amount of free memory on the server
     */
    public int getFreeMemory() {
        return freeMemory;
    }
    /**
     * Sets the amount of free memory on the server.
     *
     * @param freeMemory the new amount of free memory on the server
     */
    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }
    /**
     * Returns the active status of the server.
     *
     * @return the active status of the server
     */
    public boolean isActive() {
        return active;
    }
    /**
     * Sets the id of the server.
     *
     * @param id the new id of the server
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the server.
     *
     * @param name the new name of the server
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the active status of the server.
     *
     * @param active the new active status of the server
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
