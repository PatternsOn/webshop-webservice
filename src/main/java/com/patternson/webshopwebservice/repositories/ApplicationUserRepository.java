package com.patternson.webshopwebservice.repositories;

import com.patternson.webshopwebservice.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by Tobias Pettersson 20180113
 */
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
}
