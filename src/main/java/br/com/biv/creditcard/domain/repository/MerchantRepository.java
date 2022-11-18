package br.com.biv.creditcard.domain.repository;

import br.com.biv.creditcard.domain.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Optional<Merchant> findFirstByName(final String name);
}

