package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.UserDTO;
import com.patternson.webshopwebservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * Created by Tobias Pettersson 20180113
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);
}
