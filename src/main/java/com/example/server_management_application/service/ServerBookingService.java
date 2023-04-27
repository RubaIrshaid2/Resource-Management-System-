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
     * The allocateMemory method is responsible for allocating memory for the servers. It selects a server that has enough
     * free memory to allocate the required amount of memory on it. If no server has enough free memory, it creates a new
     * server with 100 GB of memory and allocate the required amount of memory on it. It then returns a ServerDTO object that
     * represents the selected server.
     *
     * @param size The amount of memory to be allocated in GB.
     * @return The ServerDTO object that represents the server which the memory has been allocated on.
     */
    public synchronized ServerDTO allocateMemory(int size) throws IllegalArgumentException
    {
        if(size<0 || size > 100) {
            logger.warn("the size of the memory to be located should be between 0 and 100 GB");
            throw new IllegalArgumentException("the size of the memory to be located should be between 0 and 100 GB");
        }
        logger.info("running");
        logger.info("Inside Allocating function to allocate " + size + " GB");
        Server selectedServer = ServerRepository.getSuitableServer(size);
        if(selectedServer!=null)
        {
            logger.info("The selected server to allocate "+ size +" GB of memory is "+ selectedServer.getName());
            int freeMemory = selectedServer.getFreeMemory()-size;
            selectedServer.setFreeMemory(freeMemory);
        }
        else
        {
            logger.info("Creating a new server");
            try {
                Thread.sleep(10000);
                Server NewlyCreatedServer = new Server(ServerRepository.getLastId() , "server_" + ServerRepository.getLastId() , 100-size , true);
                ServerRepository.addServer(NewlyCreatedServer);
                logger.info("Server created successfully");
                selectedServer = NewlyCreatedServer;
            }
            catch (Exception e)
            {
                logger.error("This is an error message " + e.getMessage(), new Exception("Something went wrong when creating a new server"));
            }
        }
        logger.info("allocating memory was done");
        return serverMapper.ToDTO(selectedServer);
    }
    /**
     * Retrieves a list of all servers and returns it as a list of ServerDTO objects.
     *
     * @return a list of ServerDTO objects containing details of all servers
     */
    public List<ServerDTO> getAllServers()
    {
        List<Server> servers = ServerRepository.getServers();
        List<ServerDTO> dto = new ArrayList<>();

        for(Server s : servers)
            dto.add(serverMapper.ToDTO(s));
        return dto;
    }
}
