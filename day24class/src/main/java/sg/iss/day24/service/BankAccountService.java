import main.java.sg.iss.day24.model.BankAccount;
import main.java.sg.iss.day24.repository.BankAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.day24.model.BankAccount;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepo repo;

    public BankAccount retrieveAccountById(Integer accountId){
        return repo.getAccountById();
    }

    public Boolean withdraw(Integer bankAccId, Float amount) {
        return repo.withdraw(bankAccId, amount);
    }

    public Boolean deposit(Integer bankAccId, Float amount) {
        return repo.deposit(bankAccId, amount);
    }

    public Integer createAccount(BankAccount acc) {
        return repo.createAccount(acc);
    }
}
