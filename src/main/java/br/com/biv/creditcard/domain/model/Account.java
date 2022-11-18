package br.com.biv.creditcard.domain.model;

import br.com.biv.creditcard.controller.resource.account.AccountResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ACCOUNT")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID", nullable = false, unique = true, updatable = false)
    private Long accountId;

    @Column(name = "DOCUMENT_NUMBER", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "ACCOUNT_BALANCE")
    private BigDecimal accountBalance = BigDecimal.valueOf(1000);

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToMany(mappedBy = "payment")
//    private Set<Payment> payments;


}
