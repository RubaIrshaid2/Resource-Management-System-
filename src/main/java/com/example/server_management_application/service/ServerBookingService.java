package com.example.server_management_application.service;

import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.model.Server;
import org.apache.log4j.Logger;

public class ServerBookingService {
    private static final Logger logger = Logger.getLogger(String.valueOf(ServerBookingService.class));
    public ServerDTO initialThread(int size) throws InterruptedException {
        try {
            if(size<0 || size > 100)
                throw new IllegalArgumentException("the size of the memory should be between 0 and 100 GB");
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
}
