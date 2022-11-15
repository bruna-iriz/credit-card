package br.com.biv.creditcard.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private Long accountId;
    private String documentNumber;

}
