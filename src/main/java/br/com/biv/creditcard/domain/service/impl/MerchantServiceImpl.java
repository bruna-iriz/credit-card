package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.exception.BadRequestException;
import br.com.biv.creditcard.domain.exception.account.AccountNotFoundException;
import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.repository.MerchantRepository;
import br.com.biv.creditcard.domain.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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
        return ofNullable(merchantRepository.findById(merchantId)
                .orElseThrow(() -> new AccountNotFoundException("Merchant not found")));
    }

    @Override
    public Merchant save(final Merchant merchant) {
        if (Objects.isNull(merchant.getName())) {
            throw new BadRequestException("Document number can not be null");
        }
        if (merchantRepository.findFirstByName(merchant.getName()).isPresent()) {
            throw new BadRequestException("Document number already exists");
        }
        return merchantRepository.saveAndFlush(merchant);
    }
//        return merchantRepository.save(merchant);
//    }

    @Override
    public void deleteById(Long merchantId) {
        merchantRepository.deleteById(merchantId);
    }
}
