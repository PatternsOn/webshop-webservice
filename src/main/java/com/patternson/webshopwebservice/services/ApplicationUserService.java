package com.patternson.webshopwebservice.services;

import com.patternson.webshopwebservice.api.v1.model.ApplicationUserDTO;

import java.util.List;

/**
 * Created bu Tobias Pettersson 20180113
 */
public interface ApplicationUserService {

    List<ApplicationUserDTO> getAllApplicationUsers();

    ApplicationUserDTO getApplicationUserById(Long id);

    ApplicationUserDTO createNewApplicationUser(ApplicationUserDTO applicationUserDTO);

    ApplicationUserDTO saveApplicationUserByDTO(Long id, ApplicationUserDTO applicationUserDTO);

    ApplicationUserDTO patchApplicationUser(Long id, ApplicationUserDTO applicationUserDTO);

    void deleteApplicationUserById(Long id);
}
