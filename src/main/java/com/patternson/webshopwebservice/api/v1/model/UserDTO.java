package com.patternson.webshopwebservice.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int active;

    private Set<RoleDTO> roles;

    @JsonProperty("user_url")
    private String userUrl;

}
