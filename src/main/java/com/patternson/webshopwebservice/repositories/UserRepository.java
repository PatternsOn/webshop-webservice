package com.patternson.webshopwebservice.repositories;

import com.patternson.webshopwebservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * Created by Tobias Pettersson 20180113
 */
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
