package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String accountId;
    private  double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING) //stocker dans la base de donnees se forme de streing
    private AccountType type;
    @Transient // ca veut dire ignore cette attribut
    private Customer customer;
    private Long customerId;
}
