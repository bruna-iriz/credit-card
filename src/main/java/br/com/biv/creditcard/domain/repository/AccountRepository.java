package br.com.biv.creditcard.domain.repository;

import br.com.biv.creditcard.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findFirstByDocumentNumber(final String documentNumber);
}
