package com.example.server_management_application.service;
import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.mapper.ServerMapperImpl;
import com.example.server_management_application.model.Server;
import com.example.server_management_application.repository.ServerRepository;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.stream.IntStream;
/**
 * The MemoryAllocationService class is responsible for allocating memory for servers. It implements the Runnable
 * interface so it can run in a separate thread. It provides a method to allocate memory and returns a ServerDTO object
 * that represents the server which the memory has been allocated on.
 */
public class MemoryAllocationService implements Runnable{
    /**
     * A Logger object for logging messages.
     */
    private static final Logger logger = Logger.getLogger(String.valueOf(MemoryAllocationService.class));
    static ServerMapperImpl serverMapper = new ServerMapperImpl();
    private int size;
    private ServerDTO sever ;
    /**
     * Constructor for MemoryAllocationService class.
     *
     * @param size The amount of memory to be allocated in GB.
     */
    public MemoryAllocationService(int size) {
        logger.info("MemoryAllocationService constructor");
        this.size = size;
    }
    /**
     * Getter method for the sever instance variable.
     *
     * @return The ServerDTO object that represents the server which the memory has been allocated on.
     */
    public ServerDTO getSever() {
        return sever;
    }
    /**
     * The run method is implemented from the Runnable interface. It is responsible for running the MemoryAllocationService
     * instance in a separate thread.
     */
    @Override
    public void run() {
        logger.info("running "+ Thread.currentThread().getName());
        logger.info("Allocating "+ size +" GB of memory");
        sever = allocateMemory(size);
    }
    /**
     * The allocateMemory method is responsible for allocating memory for the servers. It selects a server that has enough
     * free memory to allocate the required amount of memory on it. If no server has enough free memory, it creates a new
     * server with 100 GB of memory and allocate the required amount of memory on it. It then returns a ServerDTO object that
     * represents the selected server.
     *
     * @param size The amount of memory to be allocated in GB.
     * @return The ServerDTO object that represents the server which the memory has been allocated on.
     */
    public static synchronized ServerDTO allocateMemory(int size)
    {
        logger.info("Inside Allocating function to allocate " + size + " GB");
        List<Server>servers = ServerRepository.getServers();
        Server selectedServer = new Server();
        int index = IntStream.range(0, servers.size())
                .filter(i -> servers.get(i).getFreeMemory() >= size && servers.get(i).isActive())
                .findFirst()
                .orElse(-1);
        if(index != -1)
        {
            logger.info("The selected server to allocate "+ size +" GB of memory is "+ servers.get(index).getName());
            int freeMemory = servers.get(index).getFreeMemory()-size;
            servers.get(index).setFreeMemory(freeMemory);
            ServerRepository.updateServersList(index , freeMemory);
            selectedServer.cloneServer(servers.get(index));
        }
        else
        {
            logger.info("Creating a new server");
            try {
                Thread.sleep(10000);
                Server NewlyCreatedServer = new Server(servers.size() , "server_" + servers.size() , 100-size , true);
                ServerRepository.addServer(NewlyCreatedServer);
                logger.info("Server created successfully");
                selectedServer.cloneServer(NewlyCreatedServer);
            }
            catch (Exception e)
            {
                logger.error("This is an error message " + e.getMessage(), new Exception("Something went wrong when creating a new server"));
            }
        }
        logger.info("allocating memory was done");
        return serverMapper.ToDTO(selectedServer);
    }
}
