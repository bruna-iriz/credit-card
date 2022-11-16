package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.model.Account;
import br.com.biv.creditcard.domain.repository.AccountRepository;
import br.com.biv.creditcard.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> listAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public Account save(final Account account) {
        return accountRepository.save(account);
    }

}
