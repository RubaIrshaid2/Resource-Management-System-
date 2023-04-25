package com.example.server_management_application.dto;

import org.mapstruct.Mapper;


public class ServerDTO {
    private String name;
    private int freeMemory;
    private boolean active;

    public ServerDTO(){}

    public ServerDTO(String name, int freeMemory, boolean active) {
        this.name = name;
        this.freeMemory = freeMemory;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setActive(boolean active) {
        this.active = active;
    }
}
