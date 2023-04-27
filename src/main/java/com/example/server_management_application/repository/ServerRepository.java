package com.example.server_management_application.repository;
import com.example.server_management_application.model.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public static Server getSuitableServer(int size)
    {
        Optional<Server> s = servers.stream()
                .filter(server-> server.getFreeMemory()>=size && server.isActive())
                .findFirst();

        return s.isPresent()? s.get() : null ;
    }
    public static int getLastId()
    {
        return servers.size();
    }
}
