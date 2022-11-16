package br.com.biv.creditcard.controller.resource.merchant;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantResponse {

    private Long merchantId;
    private String name;
    private String state;
    private String country;

}
