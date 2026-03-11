package com.asistente.notas.config;

import com.asistente.notas.seguridad.JwtFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter filter) {
        FilterRegistrationBean<JwtFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(filter);
        reg.setEnabled(false);
        reg.setName("jwtFilter");
        log.info("Registro servlet del JwtFilter deshabilitado (se usará SecurityFilterChain).");
        return reg;
    }
}
