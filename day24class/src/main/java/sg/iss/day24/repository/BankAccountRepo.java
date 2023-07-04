package sg.iss.day24.repository;

import java.beans.BeanProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.iss.day24.model.BankAccount;

@Repository
public class BankAccountRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String GET_ACCOUNT_SQL = "select * from bank_account where id = ?";

    private final String WITHDRAW_SQL = "update bank_account set balance = balance - ? where id = ?";

    private final String DEPOSIT_SQL = "update bank_account set balance = balance + ? where id = ?";

    private final String CREATE_ACCOUNT_SQL = "insert into bank_account (full_name, is_blocked, is_active, account_type, balance) values (?, ?, ?, ?, ?)";
    // private final String CREATE_ACCOUNT2_SQL = "insert into bank_account values (?, ?, ?, ?, ?)";

    public BankAccount getAccountById(Integer bankAccountId) {
        BankAccount bankAccount = jdbcTemplate.queryForObject(GET_ACCOUNT_SQL, BeanPropertyRowMapper.newInstance(main.java.sg.iss.day24.model.BankAccount.class), bankAccountId);
        return bankAccount;
    }

    public Boolean withdraw(Integer bankAccId, Float withdrawAmount) {
        // "update bank_account set balance = balance - ? where id = ?"
        Integer iResult = jdbcTemplate.update(WITHDRAW_SQL, withdrawAmount, bankAccId);

        return iResult > 0 ? true : false;
    }

    public boolean deposit(Integer bankAccId, Float depositAmount) {
        Integer iResult = jdbcTemplate.update(DEPOSIT_SQL, depositAmount, bankAccId);

        return iResult > 0 ? true : false;
    }

    public Integer createAccount(BankAccount bankAccount) {
        // Boolean bCreated = false;
        // "insert into bank_account (full_name, is_blocked, is_active, account_type, balance) values (?, ?, ?, ?, ?)"
        Integer iResult = jdbcTemplate.update(CREATE_ACCOUNT_SQL, bankAccount.getFullName(), bankAccount.getIsBlocked(), bankAccount.getIsActive(), bankAccount.getAccountType(), bankAccount.getBalance());
        return iResult > 0 ? true : false; 
    }


}
