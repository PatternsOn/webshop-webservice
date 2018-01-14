package com.patternson.webshopwebservice.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * Created by Tobias Pettersson 20180113
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDTO {

    List<UserDTO> users;
}
