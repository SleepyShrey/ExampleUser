package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.customexception.NotFoundException;
import br.com.darchanjo.examples.entity.UnderLegalHold;
import br.com.darchanjo.examples.entity.UnderLegalHoldDto;
import br.com.darchanjo.examples.entity.Users;
import br.com.darchanjo.examples.repo.UnderLegalHoldRepo;
import br.com.darchanjo.examples.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UnderLegalHoldServiceImpl implements UnderLegalHoldService {

    private final UnderLegalHoldRepo underLegalHoldRepo;
    private final UserRepo userRepo;

    public UnderLegalHoldServiceImpl(UnderLegalHoldRepo underLegalHoldRepo, UserRepo userRepo) {
        this.underLegalHoldRepo = underLegalHoldRepo;
        this.userRepo = userRepo;
    }

    @Override
    public UnderLegalHoldDto addLegalHold(UnderLegalHoldDto underLegalHold, long id) {

        if(userRepo.existsById(id)){
            Users user = userRepo.getReferenceById(id);
            UnderLegalHold underLegalHold1 = new UnderLegalHold();
            underLegalHold1.setUser(user);
            underLegalHold1.setUnderLegal(underLegalHold.isUnderLegal());
            underLegalHoldRepo.save(underLegalHold1);
            return underLegalHold;
        }
        else throw new NotFoundException("User with id: "+id+ " not found");
    }

    @Override
    public UnderLegalHold getLegalHoldDetails(long id) {
        if(underLegalHoldRepo.existsById(id)) {
            return underLegalHoldRepo.getReferenceById(id);
        }else throw new NotFoundException("Legal Hold Data not found with ID: "+id);
    }

    @Override
    public UnderLegalHoldDto editLegalHold(UnderLegalHoldDto underLegalHoldDto, long id) {
        if(userRepo.existsById(id)){
            Users user = userRepo.getReferenceById(id);
            UnderLegalHold underLegalHold = underLegalHoldRepo.findLegalHoldByUserId(id);
            underLegalHold.setUser(user);
            underLegalHold.setUnderLegal(underLegalHoldDto.isUnderLegal());
            underLegalHoldRepo.save(underLegalHold);
            return underLegalHoldDto;
        }
        else throw new NotFoundException("User with id: "+id+ " not found");
    }
}
