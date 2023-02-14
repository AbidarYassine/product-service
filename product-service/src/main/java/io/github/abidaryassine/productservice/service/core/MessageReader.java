package io.github.abidaryassine.productservice.service.core;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author yassineabidar on 14/2/2023
 */
@Component
@RequiredArgsConstructor
public class MessageReader {

    private final MessageSource messageSource;

    public String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    public void setLocale(Locale locale) {
        LocaleContextHolder.setLocale(locale);
    }

}
