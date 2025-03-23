package com.estudos.desafio_dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(scale = 2, precision = 13)
    private BigDecimal total;

    @Column(scale = 2, precision = 13)
    private BigDecimal monthlyIncome;
    
    @Column(scale = 2, precision = 13)
    private BigDecimal remainingBalance;

    public Balance() {}

    public Balance(BigDecimal total, BigDecimal monthlyIncome, BigDecimal remainingBalance) {
        this.total = total;
        this.monthlyIncome = monthlyIncome;
        this.remainingBalance = remainingBalance;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        result = prime * result + ((monthlyIncome == null) ? 0 : monthlyIncome.hashCode());
        result = prime * result + ((remainingBalance == null) ? 0 : remainingBalance.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Balance other = (Balance) obj;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        if (monthlyIncome == null) {
            if (other.monthlyIncome != null)
                return false;
        } else if (!monthlyIncome.equals(other.monthlyIncome))
            return false;
        if (remainingBalance == null) {
            if (other.remainingBalance != null)
                return false;
        } else if (!remainingBalance.equals(other.remainingBalance))
            return false;
        return true;
    }
}
