//package br.com.biv.creditcard.controller.mapper.payment;
//
//import br.com.biv.creditcard.controller.resource.payment.PaymentRequest;
//import br.com.biv.creditcard.controller.resource.payment.PaymentResponse;
//import br.com.biv.creditcard.domain.model.Payment;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@AllArgsConstructor
//public class PaymentToPaymentResourceMapper {
//
//
//    private final ModelMapper modelMapper;
//
//    public Payment convertToPayment(PaymentRequest paymentRequest) {
//        return modelMapper.map(paymentRequest, Payment.class);
//    }
//
//    public PaymentResponse convertToPaymentResponse(Payment payment) {
//        return modelMapper.map(payment, PaymentResponse.class);
//    }
//
//    public List<PaymentResponse> convertToPaymentsResponseList(List<Payment> payments) {
//        return payments
//                .stream()
//                .map(this::convertToPaymentResponse)
//                .collect(Collectors.toList());
//    }
//}
