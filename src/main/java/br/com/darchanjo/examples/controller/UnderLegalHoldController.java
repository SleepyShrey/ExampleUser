package br.com.darchanjo.examples.controller;


import br.com.darchanjo.examples.entity.UnderLegalHold;
import br.com.darchanjo.examples.entity.UnderLegalHoldDto;
import br.com.darchanjo.examples.service.UnderLegalHoldServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legalHold")
public class UnderLegalHoldController {

    private final UnderLegalHoldServiceImpl underLegalHoldService;

    @Autowired
    public UnderLegalHoldController(UnderLegalHoldServiceImpl underLegalHoldService) {
        this.underLegalHoldService = underLegalHoldService;
    }

    @PostMapping("/add")
    public ResponseEntity<UnderLegalHoldDto> postUnderLegalHoldForUser(@Valid @RequestBody UnderLegalHoldDto underLegalHold, @RequestParam Long id)
    {
        return new ResponseEntity<>(underLegalHoldService.addLegalHold(underLegalHold,id), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<UnderLegalHold> getUnderLegalHold(@Valid @RequestParam Long id)
    {
        return new ResponseEntity<>(underLegalHoldService.getLegalHoldDetails(id),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<UnderLegalHoldDto> editUnderlegalHoldValue(@Valid @RequestBody UnderLegalHoldDto underLegalHoldDto, @RequestParam Long id)
    {
        return new ResponseEntity<>(underLegalHoldService.editLegalHold(underLegalHoldDto,id),HttpStatus.CREATED);
    }

}
