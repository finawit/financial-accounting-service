package com.sina.financial.accounting.chartofaccount.api.dto;

import com.sina.financial.accounting.chartofaccount.api.validate.GeneralLedgerClassificationAnnotation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record ChartOfAccountDTO(

        @NotNull(message = "{chart_of_account.parent_id.required}")
        @NotBlank(message = "{chart_of_account.parent_id.required}")
        @Pattern(regexp = "\\d+", message = "{chart_of_account.parent_id.should_be_number}")
        String parentId,

        @NotNull(message = "{chart_of_account.name.required}")
        @NotBlank(message = "{chart_of_account.name.required}")
        String name,

        @NotNull(message = "{chart_of_account.short_name.required}")
        @NotBlank(message = "{chart_of_account.short_name.required}")
        String shortName,

        @NotNull(message = "{chart_of_account.general_ledger_code.required}")
        @NotBlank(message = "{chart_of_account.general_ledger_code.required}")
        String generalLedgerCode,

        @NotNull(message = "{chart_of_account.active.required}")
        @NotBlank(message = "{chart_of_account.active.required}")
        @Pattern(regexp = "true|false", message = "{chart_of_account.active.should_be_true_or_false}")
        String active,

        @NotNull(message = "{chart_of_account.classification.required}")
        @NotBlank(message = "{chart_of_account.classification.required}")
        @GeneralLedgerClassificationAnnotation
        String classification,

        String description
        ) {
}
