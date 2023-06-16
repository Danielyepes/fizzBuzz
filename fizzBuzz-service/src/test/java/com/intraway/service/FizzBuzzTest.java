package com.intraway.service;

import com.intraway.dto.BodyCorrect;
import com.intraway.exception.BadRequestException;
import com.intraway.repository.ResponseRepository;
import com.intraway.service.impl.FizzBuzzServiceImpl;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzService;

    @Mock
    ResponseRepository repository;

    @Test
    @SneakyThrows
    public void proccessFizzBuzz() {
        BodyCorrect bodyCorrect = fizzBuzzService.processFizzBuzz(1, 3);

        assertNotNull(bodyCorrect);
    }

    @Test
    @SneakyThrows
    public void proccessFizzBuzzOne() {
        BodyCorrect bodyCorrect = fizzBuzzService.processFizzBuzz(1, 15);

        assertNotNull(bodyCorrect);
    }

    @Test
    @SneakyThrows
    public void proccessFizzBuzzException() {

        assertThrows(BadRequestException.class, ()-> fizzBuzzService.processFizzBuzz(5, -1));
    }

}
