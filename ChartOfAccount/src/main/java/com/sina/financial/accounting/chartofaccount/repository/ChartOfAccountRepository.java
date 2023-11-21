package com.sina.financial.accounting.chartofaccount.repository;

import com.sina.financial.accounting.chartofaccount.domain.ChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, Long> {
}
