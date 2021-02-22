package dev.tmtx.tzelif.entities;

public class UserInput {
    private int initialLoan;
    private int downPayment;
    private int bankId;

    public UserInput(){}
    public UserInput(int initialLoan, int downPayment, int bankId) {
        this.initialLoan = initialLoan;
        this.downPayment = downPayment;
        this.bankId = bankId;
    }

    public int getInitialLoan() {
        return initialLoan;
    }

    public void setInitialLoan(int initialLoan) {
        this.initialLoan = initialLoan;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "initialLoan=" + initialLoan +
                ", downPayment=" + downPayment +
                ", bankId=" + bankId +
                '}';
    }
}
