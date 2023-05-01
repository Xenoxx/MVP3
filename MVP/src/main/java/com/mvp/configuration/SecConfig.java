package com.mvp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;


@Configuration
@EnableWebSecurity
public class SecConfig {

    @Value("${spring.security.ldap.domain}")
    private String ldapDomain;

    @Value("${spring.security.ldap.url}")
    private String ldapUrl;

    @Bean
    public SecurityFilterChain web(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests((authorize) -> {
//                    try {
//                        authorize
//                                .anyRequest().authenticated()
//                        .and()
//                        .formLogin().permitAll()
//                        .and()
//                        .logout().permitAll();
//                    } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
//                });
        httpSecurity
                .authorizeRequests().antMatchers("/static/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated();
        return httpSecurity.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
    }
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider authenticationProvider =
                new ActiveDirectoryLdapAuthenticationProvider(ldapDomain, ldapUrl);

        authenticationProvider.setConvertSubErrorCodesToExceptions(true);
        authenticationProvider.setUseAuthenticationRequestCredentials(true);

        return authenticationProvider;
    }



}
