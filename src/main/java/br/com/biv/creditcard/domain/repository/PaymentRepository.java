//package br.com.biv.creditcard.domain.repository;
//
//import br.com.biv.creditcard.domain.model.Payment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//
//    @Modifying
//    @Query("update Account c set c.balance = c.balance + ?1 where c.idAccount = ?2")
//    void setFixedSaldoFor(Double  balance, Long accountId);
//
//}
