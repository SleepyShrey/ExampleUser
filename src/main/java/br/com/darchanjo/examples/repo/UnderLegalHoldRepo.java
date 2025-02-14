package br.com.darchanjo.examples.repo;

import br.com.darchanjo.examples.entity.UnderLegalHold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderLegalHoldRepo extends JpaRepository<UnderLegalHold,Long> {

    @Query("SELECT u FROM UnderLegalHold u WHERE u.user.userId = :id")
    public UnderLegalHold findLegalHoldByUserId(@Param("id") long id);
}
