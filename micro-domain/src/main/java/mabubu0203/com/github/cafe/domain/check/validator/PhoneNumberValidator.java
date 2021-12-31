package mabubu0203.com.github.cafe.domain.check.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mabubu0203.com.github.cafe.domain.check.CheckPhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<CheckPhoneNumber, Object> {

  @Override
  public void initialize(CheckPhoneNumber constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    return true;
  }

}