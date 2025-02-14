package br.com.darchanjo.examples.controller;

import br.com.darchanjo.examples.entity.UserEditDTO;
import br.com.darchanjo.examples.entity.Users;
import br.com.darchanjo.examples.entity.UsersDTO;
import br.com.darchanjo.examples.entity.UsersNoPassWordDTO;
import br.com.darchanjo.examples.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/post")
    public ResponseEntity<Users> postUser(@Valid @RequestBody UsersDTO user) {
        log.info("Posting User data.");
        return new ResponseEntity<>(userService.addUsers(user), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UsersNoPassWordDTO>> getAllUsers()
    {
        log.info("Getting all the users.");
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserEditDTO> editUser(@Valid @PathVariable long id, @RequestBody UserEditDTO user)
    {
        log.info("Editing users.");
        return new ResponseEntity<>(userService.postUser(id, user),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@Valid @PathVariable long id){
        log.info("Deleting Users.");
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
