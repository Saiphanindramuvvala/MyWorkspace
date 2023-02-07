package com.cognizant.updateplayer.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlayerIdGeneratorTest {
    /**
     * Method under test: {@link PlayerIdGenerator#generate(SharedSessionContractImplementor, Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate() throws HibernateException {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: org.threeten.bp.Instant
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        PlayerIdGenerator playerIdGenerator = null;
        SharedSessionContractImplementor session = null;
        Object object = null;

        // Act
        Serializable actualGenerateResult = playerIdGenerator.generate(session, object);

        // Assert
        // TODO: Add assertions on result
    }
}

