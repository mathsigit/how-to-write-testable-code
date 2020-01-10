package com.stana.controller;

import com.stana.fake.model.FakeDateTimeProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeControllerTest {

    @Test
    public void testActuateLights() {
        assertThrows(ArithmeticException.class, () -> {
            LocalDateTime time = LocalDateTime.of(2018, 10, 1, 6, 0, 0);
            SmartHomeController controller = new SmartHomeController(new FakeDateTimeProvider(time));
            controller.actuateLights(false);
            Assertions.assertNotEquals(time, controller.getLastMotionTime());
            controller.actuateLights(true);
            Assertions.assertEquals(time, controller.getLastMotionTime());
        });


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

