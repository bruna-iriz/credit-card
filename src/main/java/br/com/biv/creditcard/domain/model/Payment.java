//package br.com.biv.creditcard.domain.model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Data
//@Builder
//@Entity
//@Table(name = "TB_PAYMENT")
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class Payment implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "PAYMENT_ID", nullable = false, unique = true)
//    private Long paymentId;
//
//    @Column(name = "ACCOUNT_ID", nullable = false)
//    private Long accountId;
//
//    @Column(name = "BALANCE", nullable = false)
//    private Double balance;
//
//    @Column(name = "EVENT_DATE", nullable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
//    private LocalDateTime eventDate = LocalDateTime.now();
//
//    @ManyToOne(optional = false)
//    private Account account;
//
//    @OneToOne(optional = false)
//    private Transaction transaction;
//
//    // métodos
//    public Double depositar(Double valorDeposito) {
//        if (valorDeposito > 0) {
//            this.balance = this.balance + valorDeposito;
//            return this.balance;
//        } else {
//            return this.balance;
//        }
//    }
//
//    // conta valor negativo
//    public void saca(double valor) throws Exception {
//        if (valor > this.balance) {
//            throw new Exception("sem saldo");
//        } else {
//            this.balance -= valor;
//        }
//    }
//
//    public Double sacar(int valorSaque) {
//        if (this.balance >= valorSaque) {
//            this.balance = this.balance - valorSaque;
//            return this.balance;
//        } else {
//            return this.balance;
//        }
//    }
//
//}
