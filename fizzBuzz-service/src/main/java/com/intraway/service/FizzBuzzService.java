package com.intraway.service;

import com.intraway.dto.BodyCorrect;
import com.intraway.exception.BadRequestException;

public interface FizzBuzzService {

    /**
     * FizzBuzz process numbers
     * @param min
     * @param max
     * @return
     */
    BodyCorrect processFizzBuzz(int min, int max) throws BadRequestException;
}
