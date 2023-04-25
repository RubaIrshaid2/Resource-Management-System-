package com.example.server_management_application.resources;

import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.mapper.ServerMapperImpl;
import com.example.server_management_application.model.Server;
import com.example.server_management_application.repository.ServerRepository;
import com.example.server_management_application.service.ServerBookingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/booking")
public class ServerBookingResource {

    ServerBookingService serverBooking = new ServerBookingService();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ServerDTO locateMemory(Integer size) throws InterruptedException {
        return serverBooking.initialThread(size);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServerDTO> getAllServers()
    {
        return ServerRepository.getServers();
    }
}
