package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.controller.mapper.transaction.TransactionToTransactionResourceMapper;
import br.com.biv.creditcard.domain.exception.BadRequestException;
import br.com.biv.creditcard.domain.exception.account.AccountNotFoundException;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.repository.AccountRepository;
import br.com.biv.creditcard.domain.repository.TransactionRepository;
import br.com.biv.creditcard.domain.service.AccountService;
import br.com.biv.creditcard.domain.service.TransactionService;
import br.com.biv.creditcard.domain.service.util.AuthorizerUseCase;
import br.com.biv.creditcard.domain.service.util.ValidateBenefitsCategories;
import br.com.biv.creditcard.domain.service.util.ValidateTransactionMCC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ValidateBenefitsCategories validateBenefitsCategories;
    @Autowired
    ValidateTransactionMCC validateTransactionMCC;
    @Autowired
    TransactionToTransactionResourceMapper mapper;
    @Autowired
    AuthorizerUseCase authorizerUsecase = new AuthorizerUseCase();

    @Override
    public Transaction save(final Transaction transaction) {
        final var accountRepositoryById = accountRepository.findById(transaction.getAccountId());
        if (accountRepositoryById.isEmpty()) {
            throw new AccountNotFoundException("Unable to proceed with transaction, non-existent account.");
        }
        authorizerUsecase.validateAuthorizer(transaction);
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(Long transactionId) {
        return Optional.empty();
    }

    @Override
    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }


//    public ResponseEntity<?> sacar(@PathVariable BigDecimal amount, @PathVariable Long idAccount) {
//        Optional<Account> account = accountRepository.findById(idAccount);
//         var amountGreaterZero = amount.compareTo(BigDecimal.ZERO) > 0;
//
//
//        if (amountGreaterZero) {
//            this.accountService.sacar(amount, idAccount);
//            Transaction transaction = new Transaction(account, amount, LocalDateTime.now());
//            transactionRepository.save(transaction);
//            return new ResponseEntity<>("Saque efetuado!", HttpStatus.OK);
//
//        } else{
//
//            return new ResponseEntity<>("Saque não efetuado!", HttpStatus.OK);
//
//        }
//
//    }
}
