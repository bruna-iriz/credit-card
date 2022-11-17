package br.com.biv.creditcard.domain.exception.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.OK)
public class BalanceInsufficienteException extends RuntimeException {

    public BalanceInsufficienteException(String message) {
        super(message);
        log.error(message);
    }
}
