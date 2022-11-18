package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.exception.account.AccountNotFoundException;
import br.com.biv.creditcard.domain.model.Account;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;
    @Mock
    AccountRepository accountRepository;


    @Test
    public void shouldBeFoundAccountWithSuccess_WhenExistAccount() {

        final var account = Account
                .builder()
                .documentNumber("49")
                .accountId(1L)
                .accountBalance(BigDecimal.TEN)
                .transactions(Set.of(Transaction.builder().build()))
                .build();

        when(accountRepository.findById(anyLong())).thenReturn(Optional.ofNullable(account));
        accountService.findById(1L);

    }
}