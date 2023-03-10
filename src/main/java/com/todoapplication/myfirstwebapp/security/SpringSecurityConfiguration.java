package com.todoapplication.myfirstwebapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
//    DataBase
//    InMemory

        @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
            UserDetails userDetails = createNewUser("alvin","test");
            UserDetails userDetails2 = createNewUser("testEmployee","password");
            return new InMemoryUserDetailsManager(userDetails,userDetails2);
        }

    private  UserDetails createNewUser(String userName, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input) ;
        UserDetails userDetails =  User.builder()
               .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles("USER","ADMIN")
               .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

}
