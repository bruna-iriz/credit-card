package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.exception.BadRequestException;
import br.com.biv.creditcard.domain.exception.account.AccountNotFoundException;
import br.com.biv.creditcard.domain.model.Account;
import br.com.biv.creditcard.domain.repository.AccountRepository;
import br.com.biv.creditcard.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        return ofNullable(accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found")));
    }

    public Account save(final Account account) {
        if (Objects.isNull(account.getDocumentNumber())) {
            throw new BadRequestException("Document number can not be null");
        }
        if (accountRepository.findFirstByDocumentNumber(account.getDocumentNumber()).isPresent()) {
            throw new BadRequestException("Document number already exists");
        }
        return accountRepository.saveAndFlush(account);
    }
//    @Override
//    public Account save(final Account account) {
//        return accountRepository.save(account);
//    }

}
