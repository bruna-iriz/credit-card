package br.com.biv.creditcard.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MCCEnum {
    RESTAURANT(5811, 5812, 5813, 5814),
    SUPERMARKET(5411),
    AUDIOVISUAL_MEDIA(5815),
    MERCHANT(0);

    private Integer value;

    private MCCEnum(Integer code) {
    }

    private MCCEnum(Integer code, Integer code2, Integer code3, Integer code4) {
    }

    public static boolean getValue(Integer id) {
        return Stream.of(MCCEnum.values())
                .anyMatch(mccEnum -> mccEnum.value.equals(id));
    }
}
