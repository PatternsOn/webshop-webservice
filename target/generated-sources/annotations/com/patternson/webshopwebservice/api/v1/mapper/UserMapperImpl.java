package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.UserDTO;
import com.patternson.webshopwebservice.domain.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-03-04T20:41:02+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public User userDtoToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }
}
