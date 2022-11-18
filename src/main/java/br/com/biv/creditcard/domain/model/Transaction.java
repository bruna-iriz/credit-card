package br.com.biv.creditcard.domain.model;

import br.com.biv.creditcard.domain.enums.BenefitsCategories;
import br.com.biv.creditcard.domain.enums.MCC;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@Entity
@Table(name = "TB_TRANSACTIONS")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID", nullable = false, unique = true, updatable = false)
    private Long transactionId;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "MERCHANT_ID", nullable = false)
    private Long merchantId;


    @Column(name = "BENEFITS_CATEGORIES", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private BenefitsCategories benefitsCategories;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "MCC", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MCC mcc;

//    @Column(name = "STATUS_TRANSACTION")
//    @Enumerated(EnumType.ORDINAL)
//    private StatusTransaction statusTransaction;


//    @Column(name = "MERCHANT", nullable = false)
//    private String merchant;

    @Column(name = "EVENT_DATE", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime eventDate = LocalDateTime.now();

    @ManyToOne(optional = false)
    private Account account;

    @ManyToOne(optional = false)
    private Merchant merchant;
}
