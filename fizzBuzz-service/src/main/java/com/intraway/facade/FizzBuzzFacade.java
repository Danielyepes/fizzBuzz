package com.intraway.facade;

import com.intraway.dto.BodyCorrect;
import com.intraway.exception.BadRequestException;
import com.intraway.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzFacade {

    @Autowired
    private FizzBuzzService service;

    public BodyCorrect process(int min, int max) throws BadRequestException {
        return service.processFizzBuzz(min,max);
    }
}
