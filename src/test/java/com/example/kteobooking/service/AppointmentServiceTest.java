package com.example.kteobooking.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    void testIsPlateValid() {
        AppointmentService service = new AppointmentService(null); // Mock repository not needed for this test

        // Valid plates
        assertTrue(service.isPlateValid("ABC1234"));
        assertTrue(service.isPlateValid("XYZ5678"));

        // Invalid plates
        assertFalse(service.isPlateValid("abc1234")); // Lowercase letters
        assertFalse(service.isPlateValid("AB12345")); // Only 2 letters
        assertFalse(service.isPlateValid("ABCD123")); // 4 letters
        assertFalse(service.isPlateValid("1234ABC")); // Numbers first
        assertFalse(service.isPlateValid("ABC123"));  // Only 3 numbers
        assertFalse(service.isPlateValid(""));        // Empty string
        assertFalse(service.isPlateValid(null));      // Null value
    }
}