

package edu.glyndwr.validator.frontend.strategies.validation.implementations;

import edu.glyndwr.validator.frontend.strategies.validations.superclasses.InputValidator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class PlasCochCampusRoomNumberValidator extends InputValidator{

    @Override
    public Boolean validateInput(String input) {
             if (isNotNullOrNotEmptyOrNotBlank(input)) {
            if (Character.isLetter(input.charAt(0)) && input.length() == 4) {
                return Character.isDigit(input.charAt(1)) && Character.isDigit(input.charAt(2)) && Character.isDigit(input.charAt(3));
            }
        }
        return false;
    }


}
