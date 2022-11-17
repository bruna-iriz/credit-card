//package br.com.biv.creditcard.controller;
//
//import br.com.biv.creditcard.controller.mapper.payment.PaymentToPaymentResourceMapper;
//import br.com.biv.creditcard.domain.service.PaymentService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import javax.naming.InsufficientResourcesException;
//
//@Slf4j
//@EnableSwagger2
//@RestController
//@RequestMapping("/payments")
//public class PaymentController {
//
//    @Autowired
//    PaymentService paymentService;
//    @Autowired
//    PaymentToPaymentResourceMapper paymentToTransactionResourceMapper;
//
//    @PostMapping({"/deposit"})
//    public ResponseEntity<?> deposit(@PathVariable Double amount, @PathVariable Long id) {
//        this.paymentService.deposit(amount, id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping({"/withdraw"})
//    public ResponseEntity<?> withdraw(@PathVariable Double amount, @PathVariable Long id) throws InsufficientResourcesException {
//        if(amount <= 0){
//            throw new InsufficientResourcesException("Insufficient Balance");
//        }
//        this.paymentService.withdraw(amount, id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
////    @PostMapping
////    @ResponseStatus(HttpStatus.CREATED)
////    public PaymentResponse createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
////        log.info("[POST][REQUEST]: Creating payment {}", paymentRequest);
////        Payment payment = paymentToTransactionResourceMapper.convertToPayment(paymentRequest);
////        Payment paymentSaved = paymentService.save(payment);
////        PaymentResponse paymentResponse = paymentToTransactionResourceMapper.convertToPaymentResponse(paymentSaved);
////        log.info("[POST][RESPONSE]: Payment create with success.");
////        return paymentResponse;
////    }
//
////    @PostMapping({"/deposit"})
////    public ResponseEntity<?> deposit(@RequestBody PaymentRequest paymentRequest) {
////        log.info("[POST][REQUEST]: Depositing amount into the account {}", paymentRequest);
////        Payment payment = paymentToTransactionResourceMapper.convertToPayment(paymentRequest);
////        Payment paymentSaved = this.paymentService.save(payment);
////        PaymentResponse paymentResponse = paymentToTransactionResourceMapper.convertToPaymentResponse(paymentSaved);
////        log.info("[POST][RESPONSE]: Payment create with success.");
////        return new ResponseEntity<>(paymentSaved, HttpStatus.OK);
////    }
//
//
//}
