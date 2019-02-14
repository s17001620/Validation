package edu.glyndwr.validator.frontend.strategies.validation.implementations;

import edu.glyndwr.validator.frontend.strategies.validations.superclasses.InputValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class UKPostCodeValidator extends InputValidator {

    @Override
    public Boolean validateInput(String input) {
        if (isNotNullOrNotEmptyOrNotBlank(input)) {
            String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            return matcher.matches();
        }
        return false;
    }

}
