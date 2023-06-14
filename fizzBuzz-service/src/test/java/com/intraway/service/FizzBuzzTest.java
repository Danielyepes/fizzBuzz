package com.intraway.service;

import com.intraway.dto.BodyCorrect;
import com.intraway.service.impl.FizzBuzzServiceImpl;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzService;

    @Test
    @SneakyThrows
    public void proccessFizzBuzz() {
        BodyCorrect bodyCorrect = fizzBuzzService.processFizzBuzz(1, 3);
        System.out.println(bodyCorrect);
        Assert.assertNotNull(bodyCorrect);
    }

    @Test
    @SneakyThrows
    public void proccessFizzBuzzOne() {
        BodyCorrect bodyCorrect = fizzBuzzService.processFizzBuzz(1, 15);
        System.out.println(bodyCorrect);
        Assert.assertNotNull(bodyCorrect);
    }

}
