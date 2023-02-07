package com.authentication.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlayerRepositoryTest {
    /**
     * Method under test: {@link PlayerRepository#findByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByEmail() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   See https://diff.blue/R013 to resolve this issue.

        PlayerRepository playerRepository = null;
        playerRepository.findByEmail("foo");
    }
}

