

package edu.glyndwr.validator.frontend.strategies.validation.implementations;

import edu.glyndwr.validator.frontend.strategies.validations.superclasses.InputValidator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class WGUEmailAddressValidator extends InputValidator{

    @Override
    public Boolean validateInput(String input) {
       return isValidEmailAddress(input, "mail.glyndwr.ac.uk");
    }


}
