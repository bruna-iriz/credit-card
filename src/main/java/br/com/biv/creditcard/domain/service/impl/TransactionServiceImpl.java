package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.controller.mapper.transaction.TransactionToTransactionResourceMapper;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.repository.AccountRepository;
import br.com.biv.creditcard.domain.repository.TransactionRepository;
import br.com.biv.creditcard.domain.service.AccountService;
import br.com.biv.creditcard.domain.service.TransactionService;
import br.com.biv.creditcard.domain.service.ValidateUsecase;
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
    ValidateUsecase validateUsecase = new ValidateUsecase();

    @Override
    public Transaction save(final Transaction transaction) {
        validateUsecase.validar(transaction);
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


//    public Transaction validar(Transaction transaction, TransactionRequest transactionRequest) {
//        if (validateTransactionMCC.isValidMCCTransaction(transactionRequest)) {
//
//            try {
//                transactionRequest.setTotalAmount(validateAmountBenefit(transactionRequest));
//                System.out.println("TRANSACTION VALID ");
//            } catch (PaymentNotValidException e) {
//                return null;
//            }
//        }
//        return transaction;
//    }
//
//    public BigDecimal validateAmountBenefit(TransactionRequest transactionRequest) {
//        return validateBenefitsCategories.isBenefits(transactionRequest) ? transactionRequest.getTotalAmount().negate() : transactionRequest.getTotalAmount();
//
//    }


//    @Override
//    public Transaction save(final Transaction transaction) {
//        return transactionRepository.save(transaction);
//    }

}
