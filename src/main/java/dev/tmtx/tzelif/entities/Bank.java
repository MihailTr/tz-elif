package dev.tmtx.tzelif.entities;

import javax.persistence.*;

@Entity
@Table(name = "bankslist", schema="public")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "interest_rate")
    private int interestRate;

    @Column(name = "maximum_loan")
    private int maximumLoan;

    @Column(name = "minimum_down_payment")
    private int minimumDownPayment;

    @Column(name = "loan_term")
    private int loanTerm;

    public Bank() {
    }

    public Bank(Long id, String name, int interestRate, int maximumLoan,
                int minimumDownPayment, int loanTerm) {
        this.id = id;
        this.name = name;
        this.interestRate = interestRate;
        this.maximumLoan = maximumLoan;
        this.minimumDownPayment = minimumDownPayment;
        this.loanTerm = loanTerm;
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

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getMaximumLoan() {
        return maximumLoan;
    }

    public void setMaximumLoan(int maximumLoan) {
        this.maximumLoan = maximumLoan;
    }

    public int getMinimumDownPayment() {
        return minimumDownPayment;
    }

    public void setMinimumDownPayment(int minimumDownPayment) {
        this.minimumDownPayment = minimumDownPayment;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    @Override
    public String toString() {
        return String.format("Product: [id = %d, name = %s, interestRate " +
                        "= %d, maximumLoan = %d, minimumDownPayment = %s, loanTerm = %d]", id
                , name, interestRate, maximumLoan, minimumDownPayment,
                loanTerm);
    }
}
