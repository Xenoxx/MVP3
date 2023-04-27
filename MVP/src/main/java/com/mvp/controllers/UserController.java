package com.mvp.controllers;

import com.mvp.domain.AppUser;
import com.mvp.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/username")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final AppUserService appUserService;

    @GetMapping("/")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        return new ResponseEntity<>(
                appUserService.saveUser(appUser),
                HttpStatus.CREATED
        );
    }
    @PatchMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser appUser,
                                              @PathVariable Integer id) {
        return new ResponseEntity<>(
                appUserService.updateUser(appUser, id),
                HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        appUserService.deleteUserById(id);
    }


}
