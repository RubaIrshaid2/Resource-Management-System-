package com.example.server_management_application.resources;
import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.service.ServerBookingService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
/**
 * The ServerBookingResource class is a RESTful resource class that provides endpoints for server booking.
 */
@Path("/booking")
public class ServerBookingResource {

    /**
     * The server booking service object
     */
    ServerBookingService serverBooking = new ServerBookingService();
    /**
     * Endpoint to book a server based on the size of required memory
     * @param size the size of required memory
     * @return a response object containing the server DTO if successful or an error message if failed
     * @throws InterruptedException if there is an interruption while waiting for a server to become available
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response locateMemory(Integer size) throws InterruptedException {
        if(size<0 || size > 100)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("the size of the memory should be between 0 and 100 GB")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        ServerDTO server = serverBooking.initialThread(size);
        return Response.ok(server.toJSON(), MediaType.APPLICATION_JSON).build();
    }

    /**
     * Endpoint to retrieve a list of all servers in the system
     * @return a response object containing an array of server DTOs
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllServers()
    {
        List<ServerDTO> allServers =  serverBooking.getAllServers();
        return Response.ok(allServers.toArray(), MediaType.APPLICATION_JSON).build();
    }
}
