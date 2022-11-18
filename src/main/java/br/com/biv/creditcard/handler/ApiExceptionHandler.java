package br.com.biv.creditcard.handler;

import br.com.biv.creditcard.domain.exception.account.AccountNotFoundException;
import br.com.biv.creditcard.domain.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(AccountNotFoundException e) {
        ErrorDetails errorDetails = getErrorDetails(e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorDetails);
    }

    private ErrorDetails getErrorDetails(AccountNotFoundException e) {
        return ErrorDetails
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .devMessage(e.getClass().toString())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<?> handleBadRequestException(
            final RuntimeException e, final WebRequest request) {

        log.warn(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
