package com.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserBuilderTest {

    @Test
    void testLombokBuilderWithPrefix() {
        User user = User.builder()
                .withId(42L)
                .withUsername("BuilderPOC")
                .withActive(true)
                .build();

        // 2. Verify the fields were set correctly
        assertNotNull(user, "The user object should not be null.");
        assertEquals(42L, user.getId(), "The ID should match the builder value.");
        assertEquals("BuilderPOC", user.getUsername(), "The username should match.");
        assertTrue(user.getActive(), "The active status should be true.");
    }
}