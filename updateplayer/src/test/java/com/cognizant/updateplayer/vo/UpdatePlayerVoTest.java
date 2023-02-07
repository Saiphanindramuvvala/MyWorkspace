package com.cognizant.updateplayer.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UpdatePlayerVoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UpdatePlayerVo}
     *   <li>{@link UpdatePlayerVo#setAddress(String)}
     *   <li>{@link UpdatePlayerVo#setEmail(String)}
     *   <li>{@link UpdatePlayerVo#setMobile(String)}
     *   <li>{@link UpdatePlayerVo#setPan(String)}
     *   <li>{@link UpdatePlayerVo#setState(String)}
     *   <li>{@link UpdatePlayerVo#toString()}
     *   <li>{@link UpdatePlayerVo#getAddress()}
     *   <li>{@link UpdatePlayerVo#getEmail()}
     *   <li>{@link UpdatePlayerVo#getMobile()}
     *   <li>{@link UpdatePlayerVo#getPan()}
     *   <li>{@link UpdatePlayerVo#getState()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UpdatePlayerVo actualUpdatePlayerVo = new UpdatePlayerVo();
        actualUpdatePlayerVo.setAddress("42 Main St");
        actualUpdatePlayerVo.setEmail("jane.doe@example.org");
        actualUpdatePlayerVo.setMobile("Mobile");
        actualUpdatePlayerVo.setPan("Pan");
        actualUpdatePlayerVo.setState("MD");
        String actualToStringResult = actualUpdatePlayerVo.toString();
        assertEquals("42 Main St", actualUpdatePlayerVo.getAddress());
        assertEquals("jane.doe@example.org", actualUpdatePlayerVo.getEmail());
        assertEquals("Mobile", actualUpdatePlayerVo.getMobile());
        assertEquals("Pan", actualUpdatePlayerVo.getPan());
        assertEquals("MD", actualUpdatePlayerVo.getState());
        assertEquals("UpdatePlayerVo(email=jane.doe@example.org, mobile=Mobile, address=42 Main St, state=MD, pan=Pan)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        assertNotEquals(updatePlayerVo, null);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals2() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        assertNotEquals(updatePlayerVo, "Different type to UpdatePlayerVo");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo1);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo1.hashCode());
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals5() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("jane.doe@example.org");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals6() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress(null);
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals7() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("Mobile");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals8() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail(null);
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals9() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("jane.doe@example.org");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals10() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile(null);
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals11() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("jane.doe@example.org");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals12() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan(null);
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals13() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("jane.doe@example.org");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Method under test: {@link UpdatePlayerVo#equals(Object)}
     */
    @Test
    void testEquals14() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState(null);

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertNotEquals(updatePlayerVo, updatePlayerVo1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress(null);
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress(null);
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo1);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail(null);
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail(null);
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo1);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile(null);
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile(null);
        updatePlayerVo1.setPan("Pan");
        updatePlayerVo1.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo1);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdatePlayerVo#equals(Object)}
     *   <li>{@link UpdatePlayerVo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals18() {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan(null);
        updatePlayerVo.setState("MD");

        UpdatePlayerVo updatePlayerVo1 = new UpdatePlayerVo();
        updatePlayerVo1.setAddress("42 Main St");
        updatePlayerVo1.setEmail("jane.doe@example.org");
        updatePlayerVo1.setMobile("Mobile");
        updatePlayerVo1.setPan(null);
        updatePlayerVo1.setState("MD");
        assertEquals(updatePlayerVo, updatePlayerVo1);
        int expectedHashCodeResult = updatePlayerVo.hashCode();
        assertEquals(expectedHashCodeResult, updatePlayerVo1.hashCode());
    }
}

