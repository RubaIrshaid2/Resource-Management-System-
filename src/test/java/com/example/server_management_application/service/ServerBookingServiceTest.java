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
    private ServerBookingService serverService;

    @Mock
    private ServerRepository dataBaseService;

    @BeforeEach
    public void setUp() {

        dataBaseService = mock(ServerRepository.class);
        serverService = new ServerBookingService(dataBaseService);
    }
    @Test
    public void when_GetAllServersIsCalled_expect_returningDTOServers()
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
    public void when_2serversExist_expect_theSizeOfTheListOfTheServersIs2()
    {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server(0,"server_0",60,true));
        serverList.add(new Server(1,"server_1",20,true));

        when(dataBaseService.getServers()).thenReturn(serverList);

        List<ServerDTO> actualList = serverService.getAllServers();
        assertEquals(2 , actualList.size());
    }

    @Test
    public void when_allocatingMemoryWithSize20_expect_returnServerDTOObjectWithFreeMemory80() {

        ServerDTO server1 = new ServerDTO("server_0",80,true);

        when(dataBaseService.getLastId()).thenReturn(0);
        ServerDTO expectedServer1 = serverService.allocateMemory(20);

        assertEquals(server1,expectedServer1);
    }

    @Test
    public void when_allocatingMultipleServers_expect_returningServersWithCorrectFreeMemory()
    {
        ServerDTO server1 = new ServerDTO("server_0",80,true);

        when(dataBaseService.getLastId()).thenReturn(0);
        ServerDTO expectedServer1 = serverService.allocateMemory(20);

        assertEquals(server1,expectedServer1);

        ServerDTO server2 = new ServerDTO("server_0",40,true);

        Server serverToReturn = new Server(0,"server_0",80,true);

        when(dataBaseService.getSuitableServer(40)).thenReturn(serverToReturn);
        ServerDTO expectedServer2 = serverService.allocateMemory(40);

        assertEquals(server2,expectedServer2);

        ServerDTO server3 = new ServerDTO("server_1",10,true);

        when(dataBaseService.getLastId()).thenReturn(1);
        ServerDTO expectedServer3 = serverService.allocateMemory(90);

        assertEquals(server3,expectedServer3);

    }
    @Test
    public void When_requestForMemoryGreaterThan100_expect_thrwosIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class , ()->serverService.allocateMemory(900));
    }
}


