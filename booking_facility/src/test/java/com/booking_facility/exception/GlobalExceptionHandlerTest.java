package com.booking_facility.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import feign.FeignException;

import java.io.DataInputStream;

import java.util.HashSet;
import java.util.Map;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.http.MockHttpInputMessage;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.booking_facility.exception.GlobalExceptionHandler;
import com.booking_facility.exception.SlotUnavailableException;

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
        //       at com.cognizant.booking_facility.exception.GlobalExceptionHandler.handleValidationError(GlobalExceptionHandler.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleValidationError(null);
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleLoginException(HttpMessageNotReadableException)}
     */
    @Test
    void testHandleLoginException() {
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
    void testHandleLoginException2() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleLoginExceptionResult = globalExceptionHandler
                .handleLoginException(new HttpMessageNotReadableException("https://example.org/example",
                        new MockHttpInputMessage(mock(DataInputStream.class))));
        assertEquals(1, actualHandleLoginExceptionResult.size());
        assertEquals("Provide JSON FORMATED type", actualHandleLoginExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#cannotCreateTransactionException(CannotCreateTransactionException, WebRequest)}
     */
    @Test
    void testCannotCreateTransactionException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        CannotCreateTransactionException exception = new CannotCreateTransactionException("Msg");
        ResponseEntity<?> actualCannotCreateTransactionExceptionResult = globalExceptionHandler
                .cannotCreateTransactionException(exception, new ServletWebRequest(new MockHttpServletRequest()));
        assertNull(actualCannotCreateTransactionExceptionResult.getBody());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualCannotCreateTransactionExceptionResult.getStatusCode());
        assertTrue(actualCannotCreateTransactionExceptionResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#cannotCreateTransactionException(CannotCreateTransactionException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCannotCreateTransactionException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.transaction.CannotCreateTransactionException.contains(java.lang.Class)" because "exception" is null
        //       at com.cognizant.booking_facility.exception.GlobalExceptionHandler.cannotCreateTransactionException(GlobalExceptionHandler.java:54)
        //   See https://diff.blue/R013 to resolve this issue.

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        globalExceptionHandler.cannotCreateTransactionException(null,
                new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleFeignException(FeignException)}
     */
    @Test
    void testHandleFeignException() {
        Map<String, String> actualHandleFeignExceptionResult = (new GlobalExceptionHandler())
                .handleFeignException(mock(FeignException.class));
        assertEquals(1, actualHandleFeignExceptionResult.size());
        assertEquals("Unauthorized Feign call", actualHandleFeignExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#MissingRequestHeaderException(MissingRequestHeaderException)}
     */
    @Test
    void testMissingRequestHeaderException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualMissingRequestHeaderExceptionResult = globalExceptionHandler
                .MissingRequestHeaderException(new MissingRequestHeaderException("Header Name", null));
        assertEquals(1, actualMissingRequestHeaderExceptionResult.size());
        assertEquals("token is not present", actualMissingRequestHeaderExceptionResult.get("error"));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#ConstraintViolationException(ConstraintViolationException)}
     */
    @Test
    void testConstraintViolationException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualConstraintViolationExceptionResult = globalExceptionHandler
                .ConstraintViolationException(new ConstraintViolationException(new HashSet<>()));
        assertEquals(1, actualConstraintViolationExceptionResult.size());
        assertEquals("Constraint violated", actualConstraintViolationExceptionResult.get("error"));
    }
    
    @Test
    void testSlotUnavailableException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualSlotUnavailableExceptionResult = globalExceptionHandler
                .handleSlotException(new SlotUnavailableException("Slot Exception"));
        assertEquals(1, actualSlotUnavailableExceptionResult.size());
        assertEquals("Constraint violated", actualSlotUnavailableExceptionResult.get("error"));
    }
    
    @Test
    void testHandleSlotUnavailableException2() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Map<String, String> actualHandleSlotExceptionResult = globalExceptionHandler
                .handleSlotException(new SlotUnavailableException("An error occurred"));
        assertEquals(1, actualHandleSlotExceptionResult.size());
        assertEquals("An error occurred", actualHandleSlotExceptionResult.get("error"));
    }
}

