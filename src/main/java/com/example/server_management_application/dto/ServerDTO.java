package com.example.server_management_application.dto;
import com.google.gson.Gson;
/**
 *The ServerDTO class represents a server in the server management application.
 *It contains the name of the server, the amount of free memory on the server, and whether the server is active or not.
 */
public class ServerDTO {
    /**
     * The name of the server.
     */
    private String name;
    /**
     * The amount of free memory on the server.
     */
    private int freeMemory;
    /**
     * Whether the server is active or not.
     */
    private boolean active;
    /**
     * Constructs an empty ServerDTO object.
     */
    public ServerDTO(){}

    /**
     * Constructs a ServerDTO object with the given parameters.
     *
     * @param name the name of the server
     * @param freeMemory the amount of free memory on the server
     * @param active whether the server is active or not
     */
    public ServerDTO(String name, int freeMemory, boolean active) {
        this.name = name;
        this.freeMemory = freeMemory;
        this.active = active;
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
     * Sets the name of the server.
     * @param name the new name of the server
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the amount of free memory on the server.
     * @return the amount of free memory on the server.
     */
    public int getFreeMemory() {
        return freeMemory;
    }

    /**
     * Sets the amount of the free memory on the server.
     * @param freeMemory the amount of free memory on the server.
     */
    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    /**
     * Returns whether the server is active or not.
     * @return true if the server is active , false otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether the server is active or not.
     * @param active true if the server is active, false otherwise.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns a json representation of the ServerDTO object.
     * @return a JSON representation of the ServerDTO object
     */
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerDTO other = (ServerDTO) obj;
        return name.equals(other.name) && freeMemory == other.freeMemory && active == other.active;
    }
}
