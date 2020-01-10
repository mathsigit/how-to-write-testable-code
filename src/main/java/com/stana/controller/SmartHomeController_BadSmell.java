package com.stana.controller;

import java.time.LocalDateTime;

import static com.stana.utility.TimeUtility.getTimeOfDay_arg;

public class SmartHomeController_BadSmell {

    public LocalDateTime getLastMotionTime() {
        return lastMotionTime;
    }

    private LocalDateTime lastMotionTime;

    public void actuateLights(boolean motionDetected)
    {
        LocalDateTime time = LocalDateTime.now();// Ouch!

        // Update the time of last motion.
        if (motionDetected)
        {
            this.lastMotionTime = time;
        }

        // If motion was detected in the evening or at night, turn the light on.
        String timeOfDay = getTimeOfDay_arg(this.lastMotionTime);
        if (motionDetected && (timeOfDay == "Evening" || timeOfDay == "Night"))
        {
            BackyardLightSwitcher.TurnOn();
        }
        // If no motion is detected for one minute, or if it is morning or day, turn the light off.
//        else if (time.Subtract(LastMotionTime) > TimeSpan.FromMinutes(1) || (timeOfDay == "Morning" || timeOfDay == "Noon"))
        else if (this.lastMotionTime.getMinute() - this.lastMotionTime.getMinute() > 1 || (timeOfDay == "Morning" || timeOfDay == "Noon"))
        {
            BackyardLightSwitcher.TurnOff();
        }
    }
}
