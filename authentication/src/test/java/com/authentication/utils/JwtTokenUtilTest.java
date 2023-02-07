package com.authentication.utils;

import io.jsonwebtoken.Claims;

import java.util.ArrayList;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenUtil.class})
@ExtendWith(SpringExtension.class)
class JwtTokenUtilTest {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * Method under test: {@link JwtTokenUtil#validateToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.authentication.utils.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:67)
        //       at com.authentication.utils.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:57)
        //       at com.authentication.utils.JwtTokenUtil.getExpirationDateFromToken(JwtTokenUtil.java:47)
        //       at com.authentication.utils.JwtTokenUtil.isTokenExpired(JwtTokenUtil.java:75)
        //       at com.authentication.utils.JwtTokenUtil.validateToken(JwtTokenUtil.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.validateToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#validateToken(String, UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.authentication.utils.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:67)
        //       at com.authentication.utils.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:57)
        //       at com.authentication.utils.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:39)
        //       at com.authentication.utils.JwtTokenUtil.validateToken(JwtTokenUtil.java:107)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.validateToken("ABC123", new User("janedoe", "iloveyou", new ArrayList<>()));
    }

    /**
     * Method under test: {@link JwtTokenUtil#getUsernameFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.authentication.utils.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:67)
        //       at com.authentication.utils.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:57)
        //       at com.authentication.utils.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getUsernameFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getExpirationDateFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExpirationDateFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.authentication.utils.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:67)
        //       at com.authentication.utils.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:57)
        //       at com.authentication.utils.JwtTokenUtil.getExpirationDateFromToken(JwtTokenUtil.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getExpirationDateFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getClaimFromToken(String, Function)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetClaimFromToken() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: reactor.netty.http.server.HttpServer
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String token = "";
        Function<Claims, Object> claimsResolver = null;

        // Act
        Object actualClaimFromToken = this.jwtTokenUtil.getClaimFromToken(token, claimsResolver);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        jwtTokenUtil.generateToken(new User("janedoe", "iloveyou", new ArrayList<>()));
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.userdetails.UserDetails.getUsername()" because "userDetails" is null
        //       at com.authentication.utils.JwtTokenUtil.generateToken(JwtTokenUtil.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.generateToken(null);
    }
}

