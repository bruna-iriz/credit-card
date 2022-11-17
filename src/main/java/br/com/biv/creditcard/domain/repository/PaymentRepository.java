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
//    @Query("update Conta c set c.saldo = c.saldo + ?1 where c.idConta = ?2")
//    void setFixedSaldoFor(Double  amount, Long accountId);
//
//}
