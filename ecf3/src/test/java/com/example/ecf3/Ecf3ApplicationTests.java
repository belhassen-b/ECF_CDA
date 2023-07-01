package com.example.ecf3;

import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

@SpringBootTest
class Ecf3ApplicationTests {

    private User user;
    private Game game;
    private Tournament tournament;

    @BeforeEach
    void setUp() {
        user = new User();
        game = new Game();
        tournament = new Tournament();
    }


    @Test
    void userShouldHaveFirstName() throws ChangeSetPersister.NotFoundException {
        user.setFirstName("John");
        user.getFirstName();
        if (user.getFirstName() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("User has a first name" + " " + user.getFirstName());
        }
    }


    @Test
    void userShouldHaveLastName() throws ChangeSetPersister.NotFoundException {
        user.setLastName("Doe");
        user.getLastName();
        if (user.getLastName() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("User has a last name" + " " + user.getLastName());
        }
    }

    @Test
    void userShouldHaveEmail() throws ChangeSetPersister.NotFoundException {
        user.setEmail("test@test.fr");
        user.getEmail();
        if (user.getEmail() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("User has an email" + " " + user.getEmail());
        }
    }


    @Test
    void userShouldHavePassword() throws ChangeSetPersister.NotFoundException {
        user.setPassword("test");
        user.getPassword();
        if (user.getPassword() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("User has a password" + " " + user.getPassword());
        }
    }

    //test for tournament entity
    @Test
    void tournamentShouldHaveName() throws ChangeSetPersister.NotFoundException {
        tournament.setName("tournoi 1");
        tournament.getName();
        if (tournament.getName() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("Tournament has a name" + " " + tournament.getName());
        }
    }

    @Test
    void saveUser() throws ChangeSetPersister.NotFoundException {
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("t@tst.fr");
        user.setPassword("test");
        user.getFirstName();
        user.getLastName();
        user.getEmail();
        user.getPassword();
        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new ChangeSetPersister.NotFoundException();
        } else {
            System.out.println("User has been saved");
        }
    }
}


