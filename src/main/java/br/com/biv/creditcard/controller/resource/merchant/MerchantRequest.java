package br.com.biv.creditcard.controller.resource.merchant;

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
