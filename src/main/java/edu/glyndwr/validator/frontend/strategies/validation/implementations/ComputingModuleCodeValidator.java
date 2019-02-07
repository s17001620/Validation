package edu.glyndwr.validator.frontend.strategies.validation.implementations;

import edu.glyndwr.validator.frontend.strategies.validation.InputValidator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class ComputingModuleCodeValidator extends InputValidator {

    @Override
    public Boolean validateInput(String input) {
        if (isNotNullOrNotEmptyOrNotBlank(input)) {
            if (input.startsWith("COM") && input.length() == 6) {
                String numberString = input.substring(input.lastIndexOf("M") + 1);
                return numberString.matches("[0-9]+");
            }
        }
        return false;
    }

}
