package com.sina.financial.accounting.chartofaccount.service;

import com.sina.financial.accounting.chartofaccount.api.dto.ChartOfAccountDTO;
import com.sina.financial.accounting.chartofaccount.domain.ChartOfAccount;
import com.sina.financial.accounting.chartofaccount.repository.ChartOfAccountRepository;
import com.sina.financial.accounting.enumeration.GeneralLedgerClassification;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountService {

    private ChartOfAccountRepository repository;
    public ChartOfAccountService(ChartOfAccountRepository chartOfAccountRepository) {
        this.repository = chartOfAccountRepository;
    }

    public void addAnewChartOfAccount(ChartOfAccountDTO chartOfAccountDTO) {
        repository.save(map(chartOfAccountDTO));
    }

    private ChartOfAccount map(ChartOfAccountDTO dto) {
        ChartOfAccount chartOfAccount = new ChartOfAccount();
        chartOfAccount.setParentId(Long.parseLong(dto.parentId()));
        chartOfAccount.setGeneralLedgerCode(dto.generalLedgerCode());
        chartOfAccount.setName(dto.name());
        chartOfAccount.setShortName(dto.shortName());
        chartOfAccount.setActive(Boolean.getBoolean(dto.active()));
        chartOfAccount.setGeneralLedgerClassification(GeneralLedgerClassification.valueOf(dto.classification().toUpperCase()));
        chartOfAccount.setDescription(dto.description());

        return chartOfAccount;
    }
}
