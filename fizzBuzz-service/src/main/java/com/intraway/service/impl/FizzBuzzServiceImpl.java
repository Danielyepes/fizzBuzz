package com.intraway.service.impl;

import com.intraway.dto.BodyCorrect;
import com.intraway.exception.CustomErrorException;
import com.intraway.service.FizzBuzzService;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public BodyCorrect processFizzBuzz(int min, int max) throws CustomErrorException {
    	validate(min,max);

        String fizzBuzz  = foundFizzBuzz(min,max);
        BodyCorrect bodyCorrect = BodyCorrect.builder().timestamp(
                String.valueOf(System.currentTimeMillis()))
                .description(resolveDescription(fizzBuzz)).list(fizzBuzz).build();

        return bodyCorrect;
    }

    private String foundFizzBuzz(int min, int max){
        String message = "";
        for(int i = min; i <= max; i++){
            String tempMessage = FizzBuzz(i);
            message += tempMessage.isEmpty() ? i +"," : tempMessage;
        }

        return message;

    }

    private String FizzBuzz(int num){
        String message = "";
        if(multipleOf(num,3)){
            message+="Fizz";
        }
        if(multipleOf(num,5)){
            message+="Buzz";
        }
        return message;
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

    private void validate(int min, int max) throws CustomErrorException {
		if(min >max) {
			throw  new CustomErrorException("Los parámetros enviados son incorrectos");
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
