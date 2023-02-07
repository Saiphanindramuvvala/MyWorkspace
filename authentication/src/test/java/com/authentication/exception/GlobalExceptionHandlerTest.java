package com.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.DataInputStream;
import java.util.Map;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.http.MockHttpInputMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class GlobalExceptionHandlerTest {
    /**
     * Method under test: {@link GlobalExceptionHandler#handleValidationError(MethodArgumentNotValidException)}
     */
    @Test
    void testHandleValidationError() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        assertTrue(globalExceptionHandler
                .handleValidationError(new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")))
                .isEmpty());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleValidationError(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleValidationError2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.bind.MethodArgumentNotValidException.getBindingResult()" because "ex" is null
        //       at com.authentication.exception.GlobalExceptionHandler.handleValidationError(GlobalExceptionHandler.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleValidationError(null);
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleRegistrationException(RegistrationException)}
     */
    @Test
    void testHandleRegistrationException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleRegistrationExceptionResult = globalExceptionHandler
                .handleRegistrationException(new RegistrationException("An error occurred"));
        assertEquals(1, actualHandleRegistrationExceptionResult.size());
        assertEquals("An error occurred", actualHandleRegistrationExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleRegistrationException(RegistrationException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleRegistrationException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.authentication.exception.RegistrationException.getMessage()" because "ex" is null
        //       at com.authentication.exception.GlobalExceptionHandler.handleRegistrationException(GlobalExceptionHandler.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleRegistrationException(null);
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException()}
     */
    @Test
    void testHandleLoginException() {
        Map<String, String> actualHandleLoginExceptionResult = (new GlobalExceptionHandler()).handleLoginException();
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("TOKEN NOT VALID", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(LoginException)}
     */
    @Test
    void testHandleLoginException2() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleLoginExceptionResult = globalExceptionHandler
                .handleLoginException(new LoginException("An error occurred"));
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("An error occurred", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(LoginException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleLoginException3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.authentication.exception.LoginException.getMessage()" because "ex" is null
        //       at com.authentication.exception.GlobalExceptionHandler.handleLoginException(GlobalExceptionHandler.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleLoginException((LoginException) null);
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(HttpMessageNotReadableException)}
     */
    @Test
    void testHandleLoginException4() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleLoginExceptionResult = globalExceptionHandler
                .handleLoginException(new HttpMessageNotReadableException("https://example.org/example"));
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("Provide JSON FORMATED type", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(HttpMessageNotReadableException)}
     */
    @Test
    void testHandleLoginException5() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleLoginExceptionResult = globalExceptionHandler
                .handleLoginException(new HttpMessageNotReadableException("https://example.org/example",
                        new MockHttpInputMessage(mock(DataInputStream.class))));
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("Provide JSON FORMATED type", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(UsernameNotFoundException)}
     */
    @Test
    void testHandleLoginException6() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleLoginExceptionResult = globalExceptionHandler
                .handleLoginException(new UsernameNotFoundException("Msg"));
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("Msg", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(UsernameNotFoundException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleLoginException7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.userdetails.UsernameNotFoundException.getMessage()" because "ex" is null
        //       at com.authentication.exception.GlobalExceptionHandler.handleLoginException(GlobalExceptionHandler.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleLoginException((UsernameNotFoundException) null);
    }
}

