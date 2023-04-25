package com.example.server_management_application.mapper;

import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.model.Server;
import org.mapstruct.Mapper;

@Mapper
public interface ServerMapper {

    ServerDTO ToDTO(Server server);

    Server ToEntity(ServerDTO serverDTO);
}
