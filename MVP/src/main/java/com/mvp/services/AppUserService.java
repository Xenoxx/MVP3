package com.mvp.services;

import com.mvp.domain.AppUser;

import java.util.List;


public interface AppUserService {

    AppUser getUserById(Integer id);

    List<AppUser> getAllUsers();

    AppUser saveUser(AppUser appUser);
    AppUser updateUser(AppUser appUser, Integer id);

    void deleteUserById(Integer id);


}
