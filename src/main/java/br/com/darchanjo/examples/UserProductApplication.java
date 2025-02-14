package br.com.darchanjo.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProductApplication.class, args);
    }

//    @Bean
//    public UserValidation userValidation()
//    {
//        return new UserValidation();
//    }
}