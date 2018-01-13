package com.patternson.webshopwebservice.controllers.v1;

import com.patternson.webshopwebservice.api.v1.model.ApplicationUserDTO;
import com.patternson.webshopwebservice.api.v1.model.ApplicationUserListDTO;
import com.patternson.webshopwebservice.services.ApplicationUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 *
 * Created by Tobias Pettersson 20180113
 */
@Slf4j
@RestController
@RequestMapping(ApplicationUserController.BASE_URL)
public class ApplicationUserController {

    public static final String BASE_URL = "/api/v1/applicationUsers";

    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUserListDTO getListOfApplicationUsers() {
        return new ApplicationUserListDTO(applicationUserService.getAllApplicationUsers());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUserDTO getApplicationUserById(@PathVariable Long id) {
        return applicationUserService.getApplicationUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationUserDTO createNewApplicationUser(@RequestBody ApplicationUserDTO applicationUserDTO) {
        return applicationUserService.createNewApplicationUser(applicationUserDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUserDTO updateApplicationUser(@PathVariable Long id, @RequestBody ApplicationUserDTO applicationUserDTO) {
        return applicationUserService.saveApplicationUserByDTO(id, applicationUserDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUserDTO patchApplicationUser(@PathVariable Long id, @RequestBody ApplicationUserDTO applicationUserDTO) {
        return applicationUserService.patchApplicationUser(id, applicationUserDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteApplicationUser(@PathVariable Long id) {
        applicationUserService.deleteApplicationUserById(id);
    }

}
