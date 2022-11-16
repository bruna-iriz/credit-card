package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.repository.MerchantRepository;
import br.com.biv.creditcard.domain.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public List<Merchant> listAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Optional<Merchant> findById(Long merchantId) {
        return merchantRepository.findById(merchantId);
    }

    @Override
    public Merchant save(final Merchant merchant) {
        return merchantRepository.save(merchant);
    }

}
