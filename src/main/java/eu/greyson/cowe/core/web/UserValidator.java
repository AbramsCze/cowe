package eu.greyson.cowe.core.web;

import eu.greyson.cowe.core.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator for <code>User</code> forms.
 * We're not using Bean Validation annotations here because it is easier to define such validation rule in Java.
 */
public class UserValidator implements Validator
{
    private static final String REQUIRED = "required";

    @Override
    public void validate(final Object obj, final Errors errors)
    {
        User user = (User) obj;

        // firstName validation
        if (StringUtils.isBlank(user.getFirstName()))
        {
            errors.rejectValue("firstName", REQUIRED, REQUIRED);
        }

        // password validation
        if (user.isNew() && StringUtils.isBlank(user.getPassword()))
        {
            errors.rejectValue("password", REQUIRED, REQUIRED);
        }
    }

    /** This Validator validates *just* User instances. */
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }
}
