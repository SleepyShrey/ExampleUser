package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.entity.UnderLegalHold;
import br.com.darchanjo.examples.entity.UnderLegalHoldDto;

public interface UnderLegalHoldService {

    public UnderLegalHoldDto addLegalHold(UnderLegalHoldDto underLegalHold, long id);
    public UnderLegalHold getLegalHoldDetails(long id);
    public UnderLegalHoldDto editLegalHold(UnderLegalHoldDto underLegalHoldDto, long id);
}
