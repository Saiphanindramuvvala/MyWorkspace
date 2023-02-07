package com.authentication.config;

import com.authentication.service.PlayerDetailService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PlayerDetailService playerDetailService;

    // @Autowired
    // private PlayerRequestFilter playerRequestFilter;

    @Autowired
    private PlayerAuthenticationEntryPoint playerAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //Don't authorize the request for the these endpoints.
                .authorizeRequests()
                .antMatchers("/player/login", "/player/register", "/player/validatetoken").permitAll()
                //And except the antmatchers endpoints, every request must be authenticated
                .anyRequest().authenticated()
                .and().exceptionHandling()
                //If any exceptions, call playerAuthenticationEntryPoint
                .authenticationEntryPoint(playerAuthenticationEntryPoint)
                //Stateless
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // http.addFilterBefore(playerRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(playerDetailService);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/swagger-ui.html",
                "/v3/api-docs/**",
                "/actuator/**",
                "/swagger-ui/**",
                "/webjars/**");
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components().addSecuritySchemes("bearer-key",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
