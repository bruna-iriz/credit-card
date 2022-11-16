package br.com.biv.creditcard.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorDetails {

    private int status;
    private String message;
    private String devMessage;
    private LocalDateTime timestamp;
}
