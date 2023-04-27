package com.mvp.services.implementations;

import com.mvp.domain.AppUser;
import com.mvp.repositories.AppUserRepository;
import com.mvp.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserServiceImplementation implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser getUserById(Integer id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser updateUser(AppUser appUser, Integer id) {

        AppUser userUpdate = appUserRepository.findById(id).get();
        userUpdate.setEmail(appUser.getEmail());
        userUpdate.setUserName(appUser.getUserName());
        userUpdate.setPassword(appUser.getPassword());
        return appUserRepository.save(userUpdate);
    }

    @Override
    public void deleteUserById(Integer id) {
        appUserRepository.deleteById(id);
    }
}
