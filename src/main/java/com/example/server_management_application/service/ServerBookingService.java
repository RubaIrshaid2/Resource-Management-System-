package com.example.server_management_application.service;
import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.mapper.ServerMapperImpl;
import com.example.server_management_application.model.Server;
import com.example.server_management_application.repository.ServerRepository;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *The ServerBookingService class provides methods to book a server and get a list of all servers.
 */
public class ServerBookingService {

    ServerRepository sRepo;

    public ServerBookingService(ServerRepository sRepo) {
        this.sRepo = sRepo;
    }

    public ServerBookingService() {}

    /**
     * A ServerMapperImpl object for mapping between Server and ServerDTO objects.
     */
    static ServerMapperImpl serverMapper = new ServerMapperImpl();
    /**
     * A Logger object for logging messages.
     */
    private static final Logger logger = Logger.getLogger(String.valueOf(ServerBookingService.class));
    /**
     * Allocates memory on a server and returns the server details as a ServerDTO object.
     *
     * @param size the amount of memory to allocate on the server in GB
     * @return a ServerDTO object containing details of the allocated server
     * @throws InterruptedException if the thread is interrupted while waiting for memory allocation
     */
    public ServerDTO initialThread(int size) throws InterruptedException {
        try {
            MemoryAllocationService memoryAllocationService = new MemoryAllocationService(size);
            Thread memoryAllocationThread = new Thread(memoryAllocationService);
            memoryAllocationThread.start();
            memoryAllocationThread.join();
            return memoryAllocationService.getSever();
        }
        catch (Exception e)
        {
            logger.error("This is an error message " + e.getMessage(), new Exception("Something went wrong when the request is sent"));

        }
        return null;
    }
    /**
     * Retrieves a list of all servers and returns it as a list of ServerDTO objects.
     *
     * @return a list of ServerDTO objects containing details of all servers
     */
    public List<ServerDTO> getAllServers()
    {
        List<Server> servers = ServerRepository.getServers();;
        List<ServerDTO> dto = new ArrayList<>();

        for(Server s : servers)
            dto.add(serverMapper.ToDTO(s));
        return dto;
    }
}
