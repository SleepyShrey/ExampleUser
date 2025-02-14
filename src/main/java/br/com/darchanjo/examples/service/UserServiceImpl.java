package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.customexception.NotFoundException;
import br.com.darchanjo.examples.entity.UserEditDTO;
import br.com.darchanjo.examples.entity.Users;
import br.com.darchanjo.examples.entity.UsersDTO;
import br.com.darchanjo.examples.entity.UsersNoPassWordDTO;
import br.com.darchanjo.examples.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repository;

    @Autowired
    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public UsersNoPassWordDTO getById(long id) throws NotFoundException {

        if(!repository.existsById(id))
        {
            log.error("User not found in the DataBase with id: {}",id);
            throw new NotFoundException("Id Not found "+id);
        }
        else
        {
            Users users = repository.getReferenceById(id);
            UsersNoPassWordDTO dto = new UsersNoPassWordDTO();
            dto.setEmail(users.getEmail());
            dto.setName(users.getName());
            dto.setProductEntity(users.getProductEntity());
            repository.getReferenceById(id);
            log.info("User is available with id: {}",id);
            return dto;
        }

    }

    @Override
    public Users addUsers(UsersDTO user) {

        Users user1 = new Users();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        repository.save(user1);
        log.info("User Saved successfully.");
        return user1;
    }

    @Override
    public List<UsersNoPassWordDTO> getAll() {
        List<Users> list =  repository.findAll();
        List<UsersNoPassWordDTO> users = new ArrayList<>();
        for(Users user: list)
        {
            users.add(convertToDTO(user));
        }
        return users;
    }

    @Override
    public UserEditDTO postUser(long id, UserEditDTO user) {
        Users users = repository.getReferenceById(id);
        users.setUserId(id);
        users.setName(user.getName());
        users.setEmail(user.getEmail());
        repository.save(users);
        log.info("User saved.");
        return user;
    }

    @Override
    public String deleteUser(long id) {
        repository.deleteById(id);
        log.info("User deleted id:{}",id);
        return "User "+id+" got Deleted";
    }

    public UsersNoPassWordDTO convertToDTO(Users users)
    {
        UsersNoPassWordDTO usersNoPassWordDTO = new UsersNoPassWordDTO();
        usersNoPassWordDTO.setName(users.getName());
        usersNoPassWordDTO.setEmail(users.getEmail());
        usersNoPassWordDTO.setProductEntity(users.getProductEntity());
        return usersNoPassWordDTO;
    }
}
