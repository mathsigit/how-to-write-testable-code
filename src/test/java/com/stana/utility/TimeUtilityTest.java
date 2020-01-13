package com.stana.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.stana.utility.TimeUtility.getTimeOfDay_BadSmell;
import static com.stana.utility.TimeUtility.getTimeOfDay_arg;

class TimeUtilityTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testTimeOfDay_BadSmell() {
        // Arrange phase is empty: testing static method, nothing to initialize

        // Act
        String timeOfDay = getTimeOfDay_BadSmell();
        // Assert
        Assertions.assertEquals("Morning", timeOfDay);
    }

    @Test
    public void testTimeOfDay_arg() {
        // Arrange phase is empty: testing static method, nothing to initialize

        // Act
        String timeOfDay = getTimeOfDay_arg(LocalDateTime.of(2018, 10, 1, 6, 0, 0));
        // Assert
        Assertions.assertEquals("Morning", timeOfDay);
    }

}