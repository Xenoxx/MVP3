package com.mvp.configuration;

import com.mvp.domain.AppUser;
import com.mvp.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final AppUserRepository appUserRepository;

    @Override
    public void run(String... args) throws Exception {
        if(appUserRepository.findAll().size() == 0) {
            AppUser seedUser = new AppUser();
            seedUser.setUserName("One");
            seedUser.setPassword("password");
            seedUser.setEmail("test@data.com");

            appUserRepository.save(seedUser);

            for (int i = 0; i < 27; i++) {
                AppUser user = new AppUser();
                user.setUserName(generate(9));
                user.setPassword(generate(11));
                user.setEmail(generate(6) + "@" + generate(5) + ".com");
                appUserRepository.save(user);
            }
        }
    }

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String generate(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
