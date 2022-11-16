package br.com.biv.creditcard.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum StatusTransaction {
    APPROVED("00"),
    REJECTED("51"),
    OTHERS(null);

    private static String id;

    private StatusTransaction(String id) {
    }

    public static StatusTransaction getStatusId(String StatusId) {
        return Stream.of(values())
                .filter(value -> StatusId.equalsIgnoreCase(id))
                .findAny()
                .orElse(OTHERS);
    }
}
