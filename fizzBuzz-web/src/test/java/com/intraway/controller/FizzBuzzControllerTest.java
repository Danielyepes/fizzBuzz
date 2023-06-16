package com.intraway.controller;

import com.intraway.controller.FizzBuzzController;
import com.intraway.dto.BodyCorrect;
import com.intraway.facade.FizzBuzzFacade;
import com.intraway.repository.ResponseRepository;
import com.intraway.service.FizzBuzzService;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzFacade facade;

    @MockBean
    private FizzBuzzService service;

    @MockBean
    private ResponseRepository repository;

    BodyCorrect bodyCorrect;

    @Before
    public void setup() {
        bodyCorrect = BodyCorrect.builder().build();
    }

    @Test
    @SneakyThrows
    public void fizzBuzz() {
        String url = "/intraway/api/fizzbuzz/1/14";
        when(facade.process(any(Integer.class),any(Integer.class))).thenReturn(bodyCorrect);
        MvcResult result = this.mockMvc.perform(get(url)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();

        assertNotNull(response);

    }
}
