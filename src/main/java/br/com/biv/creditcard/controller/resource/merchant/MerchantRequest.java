package br.com.biv.creditcard.controller.resource.merchant;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MerchantRequest {

    @NotNull
    private String name;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

}
