package com.example.server_management_application.resources;

import com.example.server_management_application.model.Server;
import com.example.server_management_application.repository.ServerRepository;
import com.example.server_management_application.service.ServerBookingService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/booking")
public class ServerBookingResource {

    ServerBookingService serverBooking = new ServerBookingService();
    @GET
    @Path("/{memorySize}")
    @Produces(MediaType.APPLICATION_JSON)
    public Server pp(@PathParam("memorySize") int size) throws InterruptedException {
        return serverBooking.initialThread(size);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Server> s()
    {
        return ServerRepository.getServers();
    }
}
