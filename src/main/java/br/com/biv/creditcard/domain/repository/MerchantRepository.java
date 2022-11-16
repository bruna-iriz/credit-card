package br.com.biv.creditcard.domain.repository;

import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}

