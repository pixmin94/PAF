package sg.iss.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import sg.iss.day24.model.BankAccount;

@RestController
@RequestMapping("/api/bacnkaccounts")
public class BankAccountController {
    @Autowired
    BankAccountService service;

    @PostMapping
    public ResponseEntity<Boolean> createAccount(@RequestBody BankAccount bankAccount) {
        Boolean bAccountCreated = service.createAccount(bankAccount);

        if(bAccountCreated) {
            return ResponseEntity.ok().body(bAccountCreated);
        } else {
            // exception/custom exception handling
            return ResponseEntity.internalServerError().body(bAccountCreated);
        }
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable("account-id") Integer id) {
        BankAccount bankAccount = service.retrieveAccountById(id);

        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }




}
