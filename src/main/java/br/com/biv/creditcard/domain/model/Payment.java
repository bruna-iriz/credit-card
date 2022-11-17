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
//    private Long balance;
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
//}
