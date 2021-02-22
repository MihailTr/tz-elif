package dev.tmtx.tzelif.services;

import com.sun.org.apache.xml.internal.utils.BoolStack;
import dev.tmtx.tzelif.entities.Bank;
import dev.tmtx.tzelif.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankService {
    private BankRepository bankRepository;

    @Autowired
    public void setBankRepository(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }
    public void save(Bank bank){
        bankRepository.save(bank);
    }
    public Bank getBank(Long id){
        return bankRepository.findById(id).get();
    }
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public void deleteBankById(Long id) {
        bankRepository.deleteById(id);
    }


}
