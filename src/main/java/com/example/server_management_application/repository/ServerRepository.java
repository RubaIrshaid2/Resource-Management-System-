package com.example.server_management_application.repository;

import com.example.server_management_application.model.Server;

import java.util.ArrayList;
import java.util.List;

public class ServerRepository {

    private static List<Server> servers = new ArrayList<>();

    public static List<Server> getServers() {
        return servers;
    }
    public static void addServer (Server server)
    {
        servers.add(server);
    }
    public static void updateServersList(int index , int freeMemory)
    {
        servers.get(index).setFreeMemory(freeMemory);
    }
}
