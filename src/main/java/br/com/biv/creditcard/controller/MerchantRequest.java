package br.com.biv.creditcard.controller;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MerchantRequest {

    private String name;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

}
