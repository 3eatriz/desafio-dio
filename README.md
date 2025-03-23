# Primeiro desafio da Decola Tech 2025 (DIO) - FinWise
Java RESTful API criada para o Decola Tech 2025

## Projeto no Figma

https://www.figma.com/design/TJFjDf94hdnrMJQy04KILr/Desafios-DIO-Decola-Tech-2025?node-id=0-1&t=TLCnHXOM3T30iAIL-1

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        +Long id
        +String name
        +String avatar
        +Balance balance
        +Expenses expenses
        +List<Expense> expenseList
    }

    class Balance {
        +Long id
        +BigDecimal total
        +BigDecimal monthlyIncome
        +BigDecimal remainingBalance
    }

    class Expenses {
        +Long id
        +BigDecimal monthlyTotal
        +BigDecimal total
        +BigDecimal recurring
    }

    class Expense {
        +Long id
        +String expenseName
        +NextPayment nextPayment
        +PaymentType paymentType
        +PaymentDone paymentDone
        +BigDecimal value
        +Integer currentInstallment
        +Integer totalInstallments
        +BigDecimal totalValue
        +String notes
    }

    class BaseItemPayment {
        +Long id
        +String name
        +String color
    }

    class NextPayment {
        +Long id
        +String name
        +String color
    }

    class PaymentDone {
        +Long id
        +String name
        +String color
    }

    class PaymentType {
        +Long id
        +String name
        +String color
    }

    User "1" *-- "1" Balance
    User "1" *-- "1" Expenses
    User "1" *-- "N" Expense

    Expense "N" o-- "1" PaymentType
    Expense "N" o-- "1" PaymentDone
    Expense "N" o-- "1" NextPayment

    BaseItemPayment <|-- NextPayment
    BaseItemPayment <|-- PaymentDone
    BaseItemPayment <|-- PaymentType
```
