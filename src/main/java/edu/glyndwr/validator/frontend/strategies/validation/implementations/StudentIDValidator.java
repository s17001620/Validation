

package edu.glyndwr.validator.frontend.strategies.validation.implementations;

import edu.glyndwr.validator.frontend.strategies.validation.superclasses.InputValidator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class StudentIDValidator extends InputValidator{

    @Override
    public Boolean validateInput(String input) {
       Boolean isValid = false;
       if(isNotNullOrNotEmptyOrNotBlank(input)){
           if(input.startsWith("s")){
              String numberString = input.substring(input.lastIndexOf("s") + 1);
              return numberString.matches("[0-9]+");
           }
       }
       return isValid;
    }


}
