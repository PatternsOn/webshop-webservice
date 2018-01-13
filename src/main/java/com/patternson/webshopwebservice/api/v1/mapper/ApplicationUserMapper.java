package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.ApplicationUserDTO;
import com.patternson.webshopwebservice.domain.ApplicationUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * Created by Tobias Pettersson 20180113
 */
@Mapper
public interface ApplicationUserMapper {

    ApplicationUserMapper INSTANCE = Mappers.getMapper(ApplicationUserMapper.class);

    ApplicationUserDTO applicationUserToApplicationUserDTO(ApplicationUser applicationUser);

    ApplicationUser applicationUserDtoToApplicationUser(ApplicationUserDTO applicationUserDTO);
}
