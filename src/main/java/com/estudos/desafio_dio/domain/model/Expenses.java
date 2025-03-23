package com.estudos.desafio_dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(scale = 2, precision = 13)
    private BigDecimal monthlyTotal;

    @Column(scale = 2, precision = 13)
    private BigDecimal total;

    @Column(scale = 2, precision = 13)
    private BigDecimal recurring;

    public Expenses() {
    }

    public Expenses(Long id, BigDecimal monthlyTotal, BigDecimal total, BigDecimal recurring) {
        this.id = id;
        this.monthlyTotal = monthlyTotal;
        this.total = total;
        this.recurring = recurring;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(BigDecimal monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getRecurring() {
        return recurring;
    }

    public void setRecurring(BigDecimal recurring) {
        this.recurring = recurring;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((monthlyTotal == null) ? 0 : monthlyTotal.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        result = prime * result + ((recurring == null) ? 0 : recurring.hashCode());
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
        Expenses other = (Expenses) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (monthlyTotal == null) {
            if (other.monthlyTotal != null)
                return false;
        } else if (!monthlyTotal.equals(other.monthlyTotal))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        if (recurring == null) {
            if (other.recurring != null)
                return false;
        } else if (!recurring.equals(other.recurring))
            return false;
        return true;
    }
}
