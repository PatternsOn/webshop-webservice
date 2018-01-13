package com.patternson.webshopwebservice.services;

import com.patternson.webshopwebservice.api.v1.mapper.ApplicationUserMapper;
import com.patternson.webshopwebservice.api.v1.model.ApplicationUserDTO;
import com.patternson.webshopwebservice.controllers.v1.ApplicationUserController;
import com.patternson.webshopwebservice.domain.ApplicationUser;
import com.patternson.webshopwebservice.repositories.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserMapper applicationUserMapper;
    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserMapper applicationUserMapper, ApplicationUserRepository applicationUserRepository) {
        this.applicationUserMapper = applicationUserMapper;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public List<ApplicationUserDTO> getAllApplicationUsers() {
        return applicationUserRepository
                .findAll()
                .stream()
                .map(applicationUser -> {
                    ApplicationUserDTO applicationUserDTO = applicationUserMapper.applicationUserToApplicationUserDTO(applicationUser);
                    applicationUserDTO.setApplicationUserUrl(getApplicationUserUrl(applicationUser.getId()));
                    return applicationUserDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationUserDTO getApplicationUserById(Long id) {
        return applicationUserRepository
                .findById(id)
                .map(applicationUserMapper::applicationUserToApplicationUserDTO)
                .map(userDTO -> {
                    // set API URL
                    userDTO.setApplicationUserUrl(getApplicationUserUrl(id));
                    return userDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ApplicationUserDTO createNewApplicationUser(ApplicationUserDTO applicationUserDTO) {
        return saveAndReturnDTO(applicationUserMapper.applicationUserDtoToApplicationUser(applicationUserDTO));
    }

    private ApplicationUserDTO saveAndReturnDTO(ApplicationUser applicationUser) {
        ApplicationUser savedApplicationUser = applicationUserRepository.save(applicationUser);

        ApplicationUserDTO returnDTO = applicationUserMapper.applicationUserToApplicationUserDTO(savedApplicationUser);

        returnDTO.setApplicationUserUrl(getApplicationUserUrl(savedApplicationUser.getId()));

        return returnDTO;
    }

    @Override
    public ApplicationUserDTO saveApplicationUserByDTO(Long id, ApplicationUserDTO applicationUserDTO) {
        ApplicationUser applicationUser = applicationUserMapper.applicationUserDtoToApplicationUser(applicationUserDTO);
        applicationUser.setId(id);

        return saveAndReturnDTO(applicationUser);
    }

    @Override
    public ApplicationUserDTO patchApplicationUser(Long id, ApplicationUserDTO applicationUserDTO) {
        return applicationUserRepository
                .findById(id)
                .map(applicationUser -> {
                    if (applicationUserDTO.getEmail() != null) {
                        applicationUser.setEmail(applicationUserDTO.getEmail());
                    }
                    if (applicationUserDTO.getPassword() != null) {
                        applicationUser.setPassword(applicationUserDTO.getPassword());
                    }

                    ApplicationUserDTO returnDTO = applicationUserMapper.applicationUserToApplicationUserDTO(applicationUserRepository.save(applicationUser));

                    returnDTO.setApplicationUserUrl(getApplicationUserUrl(id));

                    return returnDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    private String getApplicationUserUrl(Long id) {
        return ApplicationUserController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteApplicationUserById(Long id) {
        applicationUserRepository.deleteById(id);
    }
}
