package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.ApplicationUserDTO;
import com.patternson.webshopwebservice.domain.ApplicationUser;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-13T19:19:24+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class ApplicationUserMapperImpl implements ApplicationUserMapper {

    @Override
    public ApplicationUserDTO applicationUserToApplicationUserDTO(ApplicationUser applicationUser) {
        if ( applicationUser == null ) {
            return null;
        }

        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();

        applicationUserDTO.setEmail( applicationUser.getEmail() );
        applicationUserDTO.setPassword( applicationUser.getPassword() );

        return applicationUserDTO;
    }

    @Override
    public ApplicationUser applicationUserDtoToApplicationUser(ApplicationUserDTO applicationUserDTO) {
        if ( applicationUserDTO == null ) {
            return null;
        }

        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setEmail( applicationUserDTO.getEmail() );
        applicationUser.setPassword( applicationUserDTO.getPassword() );

        return applicationUser;
    }
}
