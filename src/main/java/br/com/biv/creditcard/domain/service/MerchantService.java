package br.com.biv.creditcard.domain.service;


import br.com.biv.creditcard.domain.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    List<Merchant> listAll();

    Optional<Merchant> findById(Long merchantId);

    Merchant save(Merchant merchant);

    void deleteById(Long merchantId);
}
