public class Calc {
    public static void main(String[] args) {
        Calc calc = new Calc();
        double res = calc.Sum(30000,5,3);
        System.out.println(res);
    }

    public double Sum(int amountBorrowed, int annualInterestRate,
                    int numberOfMonthlyPayments){
        /*
         M = monthly payment M = ежемесячный платеж
         P = amount borrowed P = сумма займа
         r = annual interest rate r = годовая процентная ставка
         n = number of monthly payments n = количество ежемесячных платежей
         */

        double M = 0;
        double P = amountBorrowed;
        double r = annualInterestRate;
        double n = numberOfMonthlyPayments;

        M = (P*(r/12)*Math.pow((1+(r/12)),n))/(Math.pow((1+(r/12)),n)-1);
        return M;
    }
}
