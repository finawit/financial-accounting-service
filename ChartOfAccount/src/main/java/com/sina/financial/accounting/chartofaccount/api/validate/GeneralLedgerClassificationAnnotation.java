package com.sina.financial.accounting.chartofaccount.api.validate;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GeneralLedgerClassificationValidator.class)
public @interface GeneralLedgerClassificationAnnotation {
    String message() default "general_ledger_classification.invalid";
    Class<?>[] groups() default {};
    Class[] payload() default {};
}

