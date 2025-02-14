package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.entity.UserEditDTO;
import br.com.darchanjo.examples.entity.Users;
import br.com.darchanjo.examples.entity.UsersDTO;
import br.com.darchanjo.examples.entity.UsersNoPassWordDTO;

import java.util.List;

public interface UserService {

    UsersNoPassWordDTO getById(long id);

    Users addUsers(UsersDTO user);

    List<UsersNoPassWordDTO> getAll();

    UserEditDTO postUser(long id, UserEditDTO user);

    String deleteUser(long id);
}
