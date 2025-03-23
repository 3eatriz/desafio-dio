# Primeiro desafio da Decola Tech 2025 (DIO) - FinWise
Java RESTful API criada para o Decola Tech 2025

## Projeto no Figma

https://www.figma.com/design/TJFjDf94hdnrMJQy04KILr/Desafios-DIO-Decola-Tech-2025?node-id=0-1&t=TLCnHXOM3T30iAIL-1

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        +long id
        +string name
        +string avatar
        +Balance balance
        +Expenses expenses
        +list<Expense> expenseList
    }

    class Balance {
        +float total
        +float monthlyIncome
        +float remainingBalance
    }

    class Expenses {
        +float monthlyTotal
        +float total
        +float recurring
    }

    class Expense {
        +long id
        +string expenseName
        +string nextPayment
        +string paymentType
        +float value
        +bool paymentDone
        +int currentInstallment
        +int totalInstallments
        +float totalValue
        +string notes
    }

    User "1" *-- "1" Balance
    User "1" *-- "1" Expenses
    User "1" *-- "N" Expense
```
