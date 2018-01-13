package com.patternson.webshopwebservice.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUserDTO {

    private String email;
    private String password;

    @JsonProperty("applicationUser_url")
    private String applicationUserUrl;
}
