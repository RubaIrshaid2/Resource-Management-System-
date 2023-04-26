package com.example.server_management_application.repository;
import com.example.server_management_application.model.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * The ServerRepository class is responsible for managing a list of servers.
 * It provides methods to retrieve, add and update servers in the list.
 */
public class ServerRepository {
    /**
     * a list to store the servers
     */
    private static List<Server> servers = new ArrayList<>();
    /**
     * Returns a list of all servers.
     *
     * @return A list of Server objects.
     */
    public static List<Server> getServers() {
        return servers;
    }
    /**
     * Adds a server to the list.
     *
     * @param server The Server object to be added.
     */
    public static void addServer (Server server)
    {
        servers.add(server);
    }
    /**
     * Updates the free memory of a server at the given index in the list after memory allocation happened on that server.
     *
     * @param index The index of the server to be updated.
     * @param freeMemory The new value of free memory to be set.
     */
    public static void updateServersList(int index , int freeMemory)
    {
        servers.get(index).setFreeMemory(freeMemory);
    }
}
