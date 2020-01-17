package com.stana.controller;

import com.stana.fake.model.FakeDateTimeProvider;
import com.stana.mock.MockLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeControllerTest {

    @Test
    public void testActuateLights() {
        // Arrange
        LocalDateTime time = LocalDateTime.of(2018, 10, 1, 6, 0, 0);
        SmartHomeController controller = new SmartHomeController(new FakeDateTimeProvider(time));
        // Act
        controller.actuateLights(true);
        // Assert
        Assertions.assertEquals(time, controller.getLastMotionTime());
    }

    /*
    * Test for HIGHER-ORDER FUNCTIONS
    **/
    @Test
    public void testActuateLightsWithHOF() {
//        LocalDateTime time = LocalDateTime.of(2018, 10, 1, 5, 59, 59);
        MockLight mockLight = new MockLight();
        SmartHomeController controller = new SmartHomeController(new FakeDateTimeProvider(LocalDateTime.of(2018, 10, 1, 5, 59, 59)));
        controller.actuateLights(true, mockLight::turnOn, mockLight::turnOff);
        Assertions.assertTrue(mockLight.isTurned);

        controller = new SmartHomeController(new FakeDateTimeProvider(LocalDateTime.of(2018, 10, 1, 6, 0, 0)));
        controller.actuateLights(true, mockLight::turnOn, mockLight::turnOff);
        Assertions.assertFalse(mockLight.isTurned);
    }

    /**
     *
     */
    @Test
    public void testDivide() {
        assertThrows(ArithmeticException.class, () ->
                Integer.divideUnsigned(42, 0));
    }

}

