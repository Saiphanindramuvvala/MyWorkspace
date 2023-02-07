package com.authentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.authentication.repository.PlayerRepository;
import com.authentication.utils.JwtTokenUtil;
import com.authentication.vo.PlayerResponse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ValidationService.class})
@ExtendWith(SpringExtension.class)
class ValidationServiceTest {
    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private ValidationService validationService;

    /**
     * Method under test: {@link ValidationService#validate(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin 7, end 6, length 6
        //       at java.lang.String.checkBoundsBeginEnd(String.java:4604)
        //       at java.lang.String.substring(String.java:2707)
        //       at java.lang.String.substring(String.java:2680)
        //       at com.authentication.service.ValidationService.validate(ValidationService.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        validationService.validate("ABC123");
    }

    /**
     * Method under test: {@link ValidationService#validate(String)}
     */
    @Test
    void testValidate2() {
        when(jwtTokenUtil.validateToken((String) any())).thenReturn(true);
        PlayerResponse actualValidateResult = validationService.validate("ABC123ABC123");
        assertEquals("BC123", actualValidateResult.getToken());
        assertTrue(actualValidateResult.isValid());
        verify(jwtTokenUtil).validateToken((String) any());
    }

    /**
     * Method under test: {@link ValidationService#validate(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.authentication.model.PlayerResponse.setValid(boolean)" because "response" is null
        //       at com.authentication.service.ValidationService.validate(ValidationService.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jwtTokenUtil.validateToken((String) any())).thenReturn(false);
        validationService.validate("ABC123ABC123");
    }
}

