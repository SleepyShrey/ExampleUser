package br.com.darchanjo.examples.repo;

import br.com.darchanjo.examples.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

}
