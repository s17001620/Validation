package edu.glyndwr.validator.frontend.strategies.validation;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
public abstract class InputValidator {

    public Boolean validateInput(String input) {
        return false;
    }

    protected Boolean isNotNullOrNotEmptyOrNotBlank(String input) {
        return null != input && !input.isEmpty() && !input.isBlank();
    }

    protected Boolean isValidEmailAddress(String input, String domain) {
        Boolean result = false;
        if (isNotNullOrNotEmptyOrNotBlank(input)) {
            if (input.endsWith(domain)) {
                try {
                    InternetAddress emailAddr = new InternetAddress(input);
                    emailAddr.validate();
                    result = true;
                } catch (AddressException ex) {
                    result = false;
                }
            }
        }
        return result;
    }
}
