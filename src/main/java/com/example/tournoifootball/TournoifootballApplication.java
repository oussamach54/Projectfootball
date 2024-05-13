package com.example.tournoifootball;

import com.example.tournoifootball.security.services.AccountService;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TournoifootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournoifootballApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {
           /* accountService.createUser("admin","123","admin@gmail.com","123");
            accountService.createUser("oussama","123","oussama@gmail.com","123");
            accountService.createUser("accountant","123","accountant@gmail.com","123");


            */







/*
            accountService.createRole("ADMIN");
            accountService.createRole("OUSSAMA");
            accountService.createRole("USER");

 */


            /*
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("oussama","OUSSAMA");
            accountService.addRoleToUser("accountant","USER");

             */
            /*
            accountService.removeRoleToUser("admin","USER");

             */

            System.out.println(accountService.loadUserByUsername("accountant").getEmail());


        };
    }
}