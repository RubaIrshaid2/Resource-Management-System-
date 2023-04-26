package com.example.server_management_application.service;

import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.model.Server;
import com.example.server_management_application.repository.ServerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServerBookingServiceTest {

    @InjectMocks
    ServerBookingService serverService;

    @Mock
    ServerRepository dataBaseService;

    @BeforeEach
    void setUp() {

        dataBaseService = mock(ServerRepository.class);
        serverService = new ServerBookingService(dataBaseService);
    }
    @Test
    void when_GetAllServersIsCalled_expect_returningDTOServers()
    {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server(0,"server_0",60,true));
        serverList.add(new Server(1,"server_1",20,true));

        when(dataBaseService.getServers()).thenReturn(serverList);

        List<ServerDTO> actualList = serverService.getAllServers();

        List<ServerDTO> expectedList = new ArrayList<>();
        expectedList.add(new ServerDTO("server_0",60,true));
        expectedList.add(new ServerDTO("server_1",20,true));

        assertEquals(expectedList , actualList);
    }

    @Test
    void when_2serversExist_expect_theSizeOfTheListOfTheServersIs2()
    {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server(0,"server_0",60,true));
        serverList.add(new Server(1,"server_1",20,true));

        when(dataBaseService.getServers()).thenReturn(serverList);

        List<ServerDTO> actualList = serverService.getAllServers();
        assertEquals(2 , actualList.size());
    }
}


