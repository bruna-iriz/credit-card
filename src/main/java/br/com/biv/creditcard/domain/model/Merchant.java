package br.com.biv.creditcard.domain.model;

import br.com.biv.creditcard.controller.resource.account.AccountResponse;
import br.com.biv.creditcard.controller.resource.merchant.MerchantResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MERCHANT")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MERCHANT_ID", nullable = false, unique = true, updatable = false)
    private Long merchantId;

    @Column(name = "NAME", length = 40, nullable = false)
    private String name;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "merchant")
    private Set<Transaction> transactions;

}
