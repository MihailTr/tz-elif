package dev.tmtx.tzelif.services;

import dev.tmtx.tzelif.entities.Bank;
import dev.tmtx.tzelif.entities.CalcResult;
import dev.tmtx.tzelif.entities.UserInput;
//import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {

    private BankService bankService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public List<CalcResult> listCalcResult(UserInput userInput){
        List<CalcResult> listResult = new ArrayList<>();
        List<Bank> allBanks = bankService.getAllBanks();
        CalcService calcService = new CalcService();
        Bank bank = bankService.getBank((long) userInput.getBankId());
        double sum =calcService.Sum(userInput.getInitialLoan(),
                bank.getInterestRate(), bank.getLoanTerm());
        CalcResult calcResult = new CalcResult(0,sum,0,0,0);
        listResult.add(calcResult);

        return listResult;
    }

    public double Sum(int amountBorrowed, int annualInterestRate,
                      int numberOfMonthlyPayments){
        /*
         M = monthly payment M = ежемесячный платеж
         P = amount borrowed P = сумма займа
         r = annual interest rate r = годовая процентная ставка
         n = number of monthly payments n = количество ежемесячных платежей
         */

        double M;
        double P = amountBorrowed;
        double r = annualInterestRate;
        double n = numberOfMonthlyPayments;

        M = (P*(r/12)*Math.pow((1+(r/12)),n))/(Math.pow((1+(r/12)),n)-1);
        return M;
    }
}
