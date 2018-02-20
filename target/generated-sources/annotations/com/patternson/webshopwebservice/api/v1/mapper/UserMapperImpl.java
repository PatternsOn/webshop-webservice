package com.patternson.webshopwebservice.api.v1.mapper;

import com.patternson.webshopwebservice.api.v1.model.RoleDTO;
import com.patternson.webshopwebservice.api.v1.model.UserDTO;
import com.patternson.webshopwebservice.domain.ApplicationUser;
import com.patternson.webshopwebservice.domain.Role;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-02-20T18:45:38+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(ApplicationUser applicationUser) {
        if ( applicationUser == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( applicationUser.getEmail() );
        userDTO.setPassword( applicationUser.getPassword() );
        userDTO.setFirstName( applicationUser.getFirstName() );
        userDTO.setLastName( applicationUser.getLastName() );
        userDTO.setActive( applicationUser.getActive() );
        userDTO.setRoles( roleSetToRoleDTOSet( applicationUser.getRoles() ) );

        return userDTO;
    }

    @Override
    public ApplicationUser userDtoToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setEmail( userDTO.getEmail() );
        applicationUser.setPassword( userDTO.getPassword() );
        applicationUser.setFirstName( userDTO.getFirstName() );
        applicationUser.setLastName( userDTO.getLastName() );
        applicationUser.setActive( userDTO.getActive() );
        applicationUser.setRoles( roleDTOSetToRoleSet( userDTO.getRoles() ) );

        return applicationUser;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRole( role.getRole() );

        return roleDTO;
    }

    protected Set<RoleDTO> roleSetToRoleDTOSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new HashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDTO( role ) );
        }

        return set1;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setRole( roleDTO.getRole() );

        return role;
    }

    protected Set<Role> roleDTOSetToRoleSet(Set<RoleDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : set ) {
            set1.add( roleDTOToRole( roleDTO ) );
        }

        return set1;
    }
}
