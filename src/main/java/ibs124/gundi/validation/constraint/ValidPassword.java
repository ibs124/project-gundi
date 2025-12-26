package ibs124.gundi.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ibs124.gundi.config.MessageConfig;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@NotBlank(message = MessageConfig.BLANK_FIELD)
@Size(min = 6, message = MessageConfig.PASSWORD_FORMAT_ERROR)
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidPassword {
    String message() default MessageConfig.PASSWORD_FORMAT_ERROR;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}