package br.com.biv.creditcard.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MCC {
    RESTAURANT("5811", "5812", "5813", "5814"),
    SUPERMARKET("5411"),
    AUDIOVISUAL_MEDIA("5815"),
    MERCHANT("4000"),
    OTHERS("0");

    private String value;

    private MCC(String id) {
    }

    private MCC(String id, String id2, String id3, String id4) {
    }

    public static MCC getMCCId(String id) {
        return Stream.of(values())
                .filter(value -> id.equalsIgnoreCase(id))
                .findAny()
                .orElse(OTHERS);
    }
}
