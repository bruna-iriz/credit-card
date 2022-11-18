//package br.com.biv.creditcard.domain.service.impl;
//
//import br.com.biv.creditcard.domain.model.Payment;
//import br.com.biv.creditcard.domain.repository.PaymentRepository;
//import br.com.biv.creditcard.domain.service.PaymentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    PaymentRepository paymentRepository;
//
//    @Override
//    public Payment save(final Payment payment) {
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public void deposit(Double amount, Long accountId) {
//        paymentRepository.setFixedSaldoFor(amount, accountId);
//    }
//
//
//    @Override
//    public void withdraw(Double amount, Long accountId) {
//        paymentRepository.setFixedSaldoFor(amount, accountId);
//    }
//
////
////    public void deposit(double value, Long id) {
////        paymentRepository.setFixedSaldoFor(quantidade, id);
////    }
//}
