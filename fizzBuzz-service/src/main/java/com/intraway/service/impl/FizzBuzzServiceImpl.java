package com.intraway.service.impl;

import com.intraway.dto.BodyCorrect;
import com.intraway.entity.Response;
import com.intraway.exception.BadRequestException;
import com.intraway.repository.ResponseRepository;
import com.intraway.service.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Autowired
    ResponseRepository responseRepository;

    @Override
    public BodyCorrect processFizzBuzz(int min, int max) throws BadRequestException {
        log.info("Execution processFizzBuzz min{} , max{}", min,max);
        //save data in repository
        saveData(min,max);

        validate(min,max);
        String fizzBuzz  = foundFizzBuzz(min,max);

        BodyCorrect bodyCorrect = BodyCorrect.builder().timestamp(
                String.valueOf(System.currentTimeMillis()))
                .description(resolveDescription(fizzBuzz)).list(fizzBuzz).build();


        return bodyCorrect;
    }

    private void saveData(int min, int max) {
        log.info("saving data min {}, max {}", min, max);
        //save transaction in repository
        Response res = Response.builder()
                .min(min).max(max).build();
        responseRepository.save(res);
    }

    private String foundFizzBuzz(int min, int max){
        String message = "";
        for(int i = min; i <= max; i++){
            message += FizzBuzz(i);
        }

        return message.substring(0, message.length() -1);

    }

    private String FizzBuzz(int num){
        String message = "";
        if(multipleOf(num,3)){
            message+="Fizz";
        }
        if(multipleOf(num,5)){
            message+="Buzz";
        }
        return message.isEmpty() ? num +"," : message +",";
    }

    private String resolveDescription(String message){
        if(message.contains("FizzBuzz")){
            return "se encontraron múltiplos de 3 y de 5";
        }else if(message.contains("Fizz")){
            return "se encontraron múltiplos de 3";
        }else  if(message.contains("Buzz")){
            return "se encontraron múltiplos de 5";
        }else{
            return "No se encontraron multiplos";
        }
    }

    private void validate(int min, int max) throws BadRequestException {
		if(min > max) {
			throw new BadRequestException("Los parámetros enviados son incorrectos");
		}
	}

	/**
     * method for if posibleMultiple is or not multiple of number
     * @param number
     * @param possibleMultiple
     * @return
     */
    private boolean multipleOf(int number, int possibleMultiple){
        return number%possibleMultiple==0;
    }

}
