package io.github.abidaryassine.productservice.interceptor;

import io.github.abidaryassine.productservice.service.core.MessageReader;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author yassineabidar on 14/2/2023
 */
@Configuration
@RequiredArgsConstructor
public class LocalInterceptor implements HandlerInterceptor {
    private final MessageReader messageReader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        messageReader.setLocale(request.getLocale());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
