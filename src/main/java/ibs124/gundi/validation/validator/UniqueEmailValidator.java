package ibs124.gundi.validation.validator;

import org.springframework.stereotype.Component;

import ibs124.gundi.service.auth.EmailReadingService;
import ibs124.gundi.validation.constraint.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final EmailReadingService readingService;

    public UniqueEmailValidator(EmailReadingService readingService) {
        this.readingService = readingService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !this.readingService.existsByName(value);
    }

}
