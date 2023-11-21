package com.sina.financial.accounting.chartofaccount.api;


import com.sina.financial.accounting.chartofaccount.api.dto.ChartOfAccountDTO;
import com.sina.financial.accounting.chartofaccount.service.ChartOfAccountService;
import com.sina.financial.accounting.enumeration.GeneralLedgerClassification;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class ChartOfAccountControllerImpl implements ChartOfAccountController{

    private ChartOfAccountService chartOfAccountService;

     public ChartOfAccountControllerImpl(ChartOfAccountService service) {
         this.chartOfAccountService = service;
     }

    //@PreAuthorize("hasRole('user')")
    public ResponseEntity<String> addChartOfAccount(
            ChartOfAccountDTO chartOfAccountDTO) {
        log.info(" the create API called");
         chartOfAccountService.addAnewChartOfAccount(chartOfAccountDTO);
        return ResponseEntity.ok("ok");
    }

}
