package com.example.accountservice.web;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  AccountRestController {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRestClient customerRestClient;
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @GetMapping("/accounts")
     public List<BankAccount> accountList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach( acc->{
            acc.setCustomer( customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList;
     }

     @GetMapping("accounts/{id}")
     public BankAccount  bankAccountById(@PathVariable String id){

        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);

        return  bankAccount;
     }


}
