package br.com.biv.creditcard.domain.model;

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
@Table(name = "TB_ACCOUNT")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MERCHANT_ID", unique = true)
    private Long accountId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "STATE", nullable = false, unique = true)
    private String state;

    @Column(name = "COUNTRY", nullable = false, unique = true)
    private String country;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;
}
