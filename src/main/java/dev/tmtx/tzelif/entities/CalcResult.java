package dev.tmtx.tzelif.entities;

public class CalcResult {
    private int month;
    private double totalPayment;
    private int interestPayment;
    private int loanBalance;
    private int equity;

    public CalcResult(){
    }

    public CalcResult(int month, double totalPayment, int interestPayment,
                      int loanBalance, int equity) {
        this.month = month;
        this.totalPayment = totalPayment;
        this.interestPayment = interestPayment;
        this.loanBalance = loanBalance;
        this.equity = equity;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(int interestPayment) {
        this.interestPayment = interestPayment;
    }

    public int getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(int loanBalance) {
        this.loanBalance = loanBalance;
    }

    public int getEquity() {
        return equity;
    }

    public void setEquity(int equity) {
        this.equity = equity;
    }

    @Override
    public String toString() {
        return "CalcResult{" +
                "month=" + month +
                ", totalPayment=" + totalPayment +
                ", interestPayment=" + interestPayment +
                ", loanBalance=" + loanBalance +
                ", equity=" + equity +
                '}';
    }
}
