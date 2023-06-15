package com.intraway.controller;

import com.intraway.exception.BadRequestException;
import com.intraway.facade.FizzBuzzFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(("/intraway/api"))
public class FizzBuzzController {

    @Autowired
    private FizzBuzzFacade facade;
    /**
     *
     * @param min min number
     * @param max max number
     * @return response of processing fizzbuzz
     */
    @GetMapping("/fizzbuzz/{min}/{max}")
    public ResponseEntity fizzBuzz(@PathVariable Integer min, @PathVariable Integer max){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(facade.process(min,max));
        }catch (BadRequestException ex){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
