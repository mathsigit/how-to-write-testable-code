package com.stana.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.stana.utility.TimeUtility.getTimeOfDay_BadSmell;

class TimeUtilityTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testTimeOfDay_BadSmell() {
        String timeOfDay = getTimeOfDay_BadSmell();

        Assertions.assertEquals("Morning", timeOfDay);
    }

    @Test
    public void testTimeOfDay_arg() {

    }
}