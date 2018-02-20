package com.patternson.webshopwebservice.services;

import com.patternson.webshopwebservice.api.v1.mapper.UserMapper;
//import com.patternson.webshopwebservice.api.v1.model.RoleDTO;
import com.patternson.webshopwebservice.api.v1.model.UserDTO;
import com.patternson.webshopwebservice.controllers.v1.UserController;
import com.patternson.webshopwebservice.domain.ApplicationUser;
import com.patternson.webshopwebservice.exceptions.ResourceNotFoundException;
import com.patternson.webshopwebservice.repositories.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserMapper userMapper, ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return applicationUserRepository
                .findAll()
                .stream()
                .map(user -> {
                    UserDTO userDTO = userMapper.userToUserDTO(user);
                    userDTO.setUserUrl(getUserUrl(user.getId()));
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return applicationUserRepository
                .findById(id)
                .map(userMapper::userToUserDTO)
                .map(userDTO -> {
                    // set API URL
                    userDTO.setUserUrl(getUserUrl(id));
                    return userDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        System.out.println("Inne i create new user" + "\n" +
                userDTO.getPassword() + "\n" +
                userDTO.getEmail() + "\n" +
                userDTO.getLastName()  + "\n" +
                userDTO.getFirstName());
//                userDTO.getRoles());


        return saveAndReturnDTO(userMapper.userDtoToUser(userDTO));
    }

    private UserDTO saveAndReturnDTO(ApplicationUser applicationUser) {
        ApplicationUser savedApplicationUser = applicationUserRepository.save(applicationUser);

        UserDTO returnDTO = userMapper.userToUserDTO(savedApplicationUser);

        returnDTO.setUserUrl(getUserUrl(savedApplicationUser.getId()));

        return returnDTO;
    }

    @Override
    public UserDTO saveUserByDTO(Long id, UserDTO userDTO) {
        ApplicationUser applicationUser = userMapper.userDtoToUser(userDTO);
        applicationUser.setId(id);

        return saveAndReturnDTO(applicationUser);
    }

    @Override
    public UserDTO patchUser(Long id, UserDTO userDTO) {
        return applicationUserRepository
                .findById(id)
                .map(user -> {
                    if (userDTO.getEmail() != null) {
                        user.setEmail(userDTO.getEmail());
                    }
                    if (userDTO.getPassword() != null) {
                        user.setPassword(userDTO.getPassword());
                    }

                    UserDTO returnDTO = userMapper.userToUserDTO(applicationUserRepository.save(user));


                    returnDTO.setUserUrl(getUserUrl(id));

                    return returnDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    private String getUserUrl(Long id) {
        return UserController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteUserById(Long id) {
        applicationUserRepository.deleteById(id);
    }
}
