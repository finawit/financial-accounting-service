package com.sina.financial.accounting.enumeration;

public enum GeneralLedgerClassification {
    ASSET(1),
    LIABILITY(2),
    EQUITY(3),
    INCOME(4),
    EXPENSE(5),
    SUBLINE(6);

    private final int typeNumber;

    GeneralLedgerClassification(int number) {
        this.typeNumber = number;
    }

    public String getName() {
        return this.toString();
    }
}
