package com.mvp.repositories;

import com.mvp.domain.AppUser;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUserName(String userName);
    Optional<AppUser> findById(Integer id);
    List<AppUser> findAll();

    void deleteById(Integer id);

}
