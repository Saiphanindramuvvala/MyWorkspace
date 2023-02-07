package com.authentication.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.authentication.service.PlayerDetailService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AuthConfig.class, AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class AuthConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AuthConfig authConfig;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private PlayerAuthenticationEntryPoint playerAuthenticationEntryPoint;

    @MockBean
    private PlayerDetailService playerDetailService;

    /**
     * Method under test: {@link AuthConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        authConfig.configure(authenticationManagerBuilder);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).getUserCache() instanceof NullUserCache);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isHideUserNotFoundExceptions());
        assertFalse(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link AuthConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.userDetailsService(org.springframework.security.core.userdetails.UserDetailsService)" because "auth" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        authConfig.configure((AuthenticationManagerBuilder) null);
    }

    /**
     * Method under test: {@link AuthConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure3() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        authenticationManagerBuilder
                .authenticationEventPublisher(new DefaultAuthenticationEventPublisher(mock(ApplicationEventPublisher.class)));
        authConfig.configure(authenticationManagerBuilder);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).getUserCache() instanceof NullUserCache);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isHideUserNotFoundExceptions());
        assertFalse(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link AuthConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.context.ApplicationContext.getBeanNamesForType(java.lang.Class)" because "context" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        authConfig.configure(new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link AuthConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure5() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.csrf()" because "http" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        authConfig.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link AuthConfig#configure(WebSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure6() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.WebSecurity$IgnoredRequestConfigurer.antMatchers(String[])" because the return value of "org.springframework.security.config.annotation.web.builders.WebSecurity.ignoring()" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        authConfig.configure(new WebSecurity(objectPostProcessor));
    }

    /**
     * Method under test: {@link AuthConfig#configure(WebSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure7() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.WebSecurity.ignoring()" because "web" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        authConfig.configure((WebSecurity) null);
    }

    /**
     * Method under test: {@link AuthConfig#configure(WebSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure8() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.WebSecurity$IgnoredRequestConfigurer.antMatchers(String[])" because the return value of "org.springframework.security.config.annotation.web.builders.WebSecurity.ignoring()" is null
        //       at com.authentication.config.AuthConfig.configure(AuthConfig.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        WebSecurity webSecurity = new WebSecurity(objectPostProcessor);
        webSecurity.postBuildAction(mock(Runnable.class));
        authConfig.configure(webSecurity);
    }

    /**
     * Method under test: {@link AuthConfig#customOpenAPI()}
     */
    @Test
    void testCustomOpenAPI() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        OpenAPI actualCustomOpenAPIResult = (new AuthConfig()).customOpenAPI();
        assertNull(actualCustomOpenAPIResult.getWebhooks());
        assertNull(actualCustomOpenAPIResult.getExtensions());
        assertNull(actualCustomOpenAPIResult.getInfo());
        assertNull(actualCustomOpenAPIResult.getSecurity());
        assertNull(actualCustomOpenAPIResult.getServers());
        assertEquals(SpecVersion.V30, actualCustomOpenAPIResult.getSpecVersion());
        assertNull(actualCustomOpenAPIResult.getTags());
        assertNull(actualCustomOpenAPIResult.getExternalDocs());
        assertEquals("3.0.1", actualCustomOpenAPIResult.getOpenapi());
        assertNull(actualCustomOpenAPIResult.getPaths());
        Components components = actualCustomOpenAPIResult.getComponents();
        assertNull(components.getCallbacks());
        assertNull(components.getRequestBodies());
        assertNull(components.getSchemas());
        assertEquals(1, components.getSecuritySchemes().size());
        assertNull(components.getExtensions());
        assertNull(components.getHeaders());
        assertNull(components.getParameters());
        assertNull(components.getResponses());
        assertNull(components.getExamples());
        assertNull(components.getLinks());
    }

    /**
     * Method under test: {@link AuthConfig#authenticationManager()}
     */
    @Test
    void testAuthenticationManager() throws Exception {
        assertTrue(authConfig.authenticationManager() instanceof ProviderManager);
    }
}

