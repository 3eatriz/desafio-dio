package com.estudos.desafio_dio.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;

    @OneToOne(cascade = CascadeType.ALL)
    private Balance balance;

    @OneToOne(cascade = CascadeType.ALL)
    private Expenses expenses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Expense> expenseList;

    public User() {}
    
    public User(Long id, String name, String avatar, Balance balance, Expenses expenses, List<Expense> expenseList) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.balance = balance;
        this.expenses = expenses;
        this.expenseList = expenseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
        result = prime * result + ((balance == null) ? 0 : balance.hashCode());
        result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
        result = prime * result + ((expenseList == null) ? 0 : expenseList.hashCode());
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (avatar == null) {
            if (other.avatar != null)
                return false;
        } else if (!avatar.equals(other.avatar))
            return false;
        if (balance == null) {
            if (other.balance != null)
                return false;
        } else if (!balance.equals(other.balance))
            return false;
        if (expenses == null) {
            if (other.expenses != null)
                return false;
        } else if (!expenses.equals(other.expenses))
            return false;
        if (expenseList == null) {
            if (other.expenseList != null)
                return false;
        } else if (!expenseList.equals(other.expenseList))
            return false;
        return true;
    }

    
}
