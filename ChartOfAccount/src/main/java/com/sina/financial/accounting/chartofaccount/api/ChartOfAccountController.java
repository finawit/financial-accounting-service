package com.sina.financial.accounting.chartofaccount.api;


import com.sina.financial.accounting.chartofaccount.api.dto.ChartOfAccountDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/v1/chart-of-account/panel")
public interface ChartOfAccountController {

    @PostMapping(value = "/create-action")
    ResponseEntity<String> addChartOfAccount(
            @Valid @RequestBody ChartOfAccountDTO chartOfAccountDTO);
}
