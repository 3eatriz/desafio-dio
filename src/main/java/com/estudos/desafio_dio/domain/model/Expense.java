package com.estudos.desafio_dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expenseName;

    @ManyToOne
    @JoinColumn(name = "next_payment_id", nullable = false)
    private NextPayment nextPayment;

    @ManyToOne
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "payment_done_id", nullable = false)
    private PaymentDone paymentDone;

    @Column(scale = 2, precision = 13, name = "expense_value", nullable = false)
    private BigDecimal value;
    private Integer currentInstallment;
    private Integer totalInstallments;

    @Column(scale = 2, precision = 13, nullable = false)
    private BigDecimal totalValue;

    @Column(length = 300, nullable = true)
    private String notes;

    public Expense() {
    }

    public Expense(Long id, String expenseName, NextPayment nextPayment, PaymentType paymentType,
            PaymentDone paymentDone, BigDecimal value, Integer currentInstallment, Integer totalInstallments,
            BigDecimal totalValue, String notes) {
        this.id = id;
        this.expenseName = expenseName;
        this.nextPayment = nextPayment;
        this.paymentType = paymentType;
        this.paymentDone = paymentDone;
        this.value = value;
        this.currentInstallment = currentInstallment;
        this.totalInstallments = totalInstallments;
        this.totalValue = totalValue;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public NextPayment getNextPayment() {
        return nextPayment;
    }

    public void setNextPayment(NextPayment nextPayment) {
        this.nextPayment = nextPayment;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentDone getPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(PaymentDone paymentDone) {
        this.paymentDone = paymentDone;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getCurrentInstallment() {
        return currentInstallment;
    }

    public void setCurrentInstallment(Integer currentInstallment) {
        this.currentInstallment = currentInstallment;
    }

    public Integer getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(Integer totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((expenseName == null) ? 0 : expenseName.hashCode());
        result = prime * result + ((nextPayment == null) ? 0 : nextPayment.hashCode());
        result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
        result = prime * result + ((paymentDone == null) ? 0 : paymentDone.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((currentInstallment == null) ? 0 : currentInstallment.hashCode());
        result = prime * result + ((totalInstallments == null) ? 0 : totalInstallments.hashCode());
        result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
        Expense other = (Expense) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (expenseName == null) {
            if (other.expenseName != null)
                return false;
        } else if (!expenseName.equals(other.expenseName))
            return false;
        if (nextPayment == null) {
            if (other.nextPayment != null)
                return false;
        } else if (!nextPayment.equals(other.nextPayment))
            return false;
        if (paymentType == null) {
            if (other.paymentType != null)
                return false;
        } else if (!paymentType.equals(other.paymentType))
            return false;
        if (paymentDone == null) {
            if (other.paymentDone != null)
                return false;
        } else if (!paymentDone.equals(other.paymentDone))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (currentInstallment == null) {
            if (other.currentInstallment != null)
                return false;
        } else if (!currentInstallment.equals(other.currentInstallment))
            return false;
        if (totalInstallments == null) {
            if (other.totalInstallments != null)
                return false;
        } else if (!totalInstallments.equals(other.totalInstallments))
            return false;
        if (totalValue == null) {
            if (other.totalValue != null)
                return false;
        } else if (!totalValue.equals(other.totalValue))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        return true;
    }
}
