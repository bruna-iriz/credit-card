package br.com.biv.creditcard.controller.mapper.merchant;

import br.com.biv.creditcard.controller.resource.merchant.MerchantRequest;
import br.com.biv.creditcard.controller.resource.merchant.MerchantResponse;
import br.com.biv.creditcard.domain.model.Merchant;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MerchanToMerchanResourceMapper {

    private final ModelMapper modelMapper;

    public Merchant convertToAccount(MerchantRequest merchantRequest) {
        return modelMapper.map(merchantRequest, Merchant.class);
    }

    public MerchantResponse convertToMerchantResponse(Merchant merchant) {
        return modelMapper.map(merchant, MerchantResponse.class);
    }

    public List<MerchantResponse> convertToMerchantsResponseList(List<Merchant> merchants) {
        return merchants
                .stream()
                .map(this::convertToMerchantResponse)
                .collect(Collectors.toList());
    }
}
