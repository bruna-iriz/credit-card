package br.com.biv.creditcard.domain.service;


import br.com.biv.creditcard.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> listAll();

    Optional<Account> findById(Long accountId);

    Account save(Account account);
}
