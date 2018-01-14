package com.patternson.webshopwebservice.services;

import com.patternson.webshopwebservice.api.v1.model.UserDTO;

import java.util.List;

/**
 * Created bu Tobias Pettersson 20180113
 */
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createNewUser(UserDTO userDTO);

    UserDTO saveUserByDTO(Long id, UserDTO userDTO);

    UserDTO patchUser(Long id, UserDTO userDTO);

    void deleteUserById(Long id);
}
