package com.example.server_management_application.mapper;
import com.example.server_management_application.dto.ServerDTO;
import com.example.server_management_application.model.Server;
import org.mapstruct.Mapper;

/**
 * The ServerMapper interface provides methods for
 * mapping Server objects to ServerDTO objects and vice versa.
 */
@Mapper
public interface ServerMapper {

    /**
     * Maps a Server object to a ServerDTO object.
     * @param server the Server object to be mapped
     * @return the corresponding ServerDTO object
     */
    ServerDTO ToDTO(Server server);

    /**
     * Maps a ServerDTO object to a Server object.
     *
     * @param serverDTO the ServerDTO object to be mapped
     * @return the corresponding Server object
     */
    Server ToEntity(ServerDTO serverDTO);
}
