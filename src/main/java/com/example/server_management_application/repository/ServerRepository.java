package com.example.server_management_application.repository;

import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.mapper.ServerMapperImpl;
import com.example.server_management_application.model.Server;

import java.util.ArrayList;
import java.util.List;

public class ServerRepository {

    private static List<Server> servers = new ArrayList<>();
    static ServerMapperImpl serverMapper = new ServerMapperImpl();
    public static List<ServerDTO> getServers() {
        List<ServerDTO> dto = new ArrayList<>();

        for(Server s : servers)
            dto.add(serverMapper.ToDTO(s));
        return dto;
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
