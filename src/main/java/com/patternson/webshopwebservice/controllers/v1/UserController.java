package com.patternson.webshopwebservice.controllers.v1;

import com.patternson.webshopwebservice.api.v1.model.UserDTO;
import com.patternson.webshopwebservice.api.v1.model.UserListDTO;
import com.patternson.webshopwebservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 *
 * created by Tobias Pettersson 20180113
 */
@Slf4j
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsers() {
        return new UserListDTO(userService.getAllUsers());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody UserDTO userDTO) {
        return userService.createNewUser(userDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.saveUserByDTO(id, userDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO patchUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.patchUser(id, userDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
