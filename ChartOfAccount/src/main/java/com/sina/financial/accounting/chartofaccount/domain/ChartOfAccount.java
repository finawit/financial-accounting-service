package com.sina.financial.accounting.chartofaccount.domain;

import com.sina.financial.accounting.entity.BaseAuditEntity;
import com.sina.financial.accounting.enumeration.GeneralLedgerClassification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "CHART_OF_ACCOUNT")
@EntityListeners(AuditingEntityListener.class)
public class ChartOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PARENT_ID")
    private Long parentId;
    @Column(name = "GENERAL_LEDGER_CODE", length = 10)
    private String generalLedgerCode;

    @Column(name = "NAME", length = 150)
    private String name;

    @Column(name = "SHORT_NAME", length = 150)
    private String shortName;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "CLASSIFICATION", length = 9)
    private GeneralLedgerClassification generalLedgerClassification;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @Embedded
    private BaseAuditEntity baseAuditEntity = new BaseAuditEntity();
}
