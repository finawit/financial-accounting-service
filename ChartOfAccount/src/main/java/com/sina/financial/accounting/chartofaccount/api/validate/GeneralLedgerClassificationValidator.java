package com.sina.financial.accounting.chartofaccount.api.validate;

import com.sina.financial.accounting.enumeration.GeneralLedgerClassification;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GeneralLedgerClassificationValidator implements ConstraintValidator<GeneralLedgerClassificationAnnotation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are handled by @NotNull or @Nullable annotations
        } else {
            try {
                GeneralLedgerClassification.valueOf(value.toUpperCase()); // Throws an exception if the value is not a valid general ledger classification
                return true;
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
    }
}
