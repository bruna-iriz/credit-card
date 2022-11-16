package br.com.biv.creditcard.controller.resource.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountRequest {

    @NotBlank
    @JsonProperty("document_number")
    private String documentNumber;
}
