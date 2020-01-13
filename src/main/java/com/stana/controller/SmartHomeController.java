package com.stana.controller;

import com.stana.it.Action;
import com.stana.it.IDateTimeProvider;
import java.time.LocalDateTime;
import static com.stana.utility.TimeUtility.getTimeOfDay_arg;

public class SmartHomeController {
    public LocalDateTime getLastMotionTime() {
        return lastMotionTime;
    }

    public void setLastMotionTime(LocalDateTime lastMotionTime) {
        this.lastMotionTime = lastMotionTime;
    }

    private LocalDateTime lastMotionTime;
    private final IDateTimeProvider _dateTimeProvider;
    public SmartHomeController(IDateTimeProvider dateTimeProvider) {
        this._dateTimeProvider = dateTimeProvider;
    }

    public void actuateLights(boolean motionDetected)
    {
        LocalDateTime time = this._dateTimeProvider.getDateTime();
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

    public void actuateLights(boolean motionDetected, Action turnOn, Action turnOff){
        LocalDateTime time = this._dateTimeProvider.getDateTime();
        // Update the time of last motion.
        if (motionDetected)
        {
            this.lastMotionTime = time;
        }

        // If motion was detected in the evening or at night, turn the light on.
        String timeOfDay = getTimeOfDay_arg(this.lastMotionTime);
        if (motionDetected && (timeOfDay == "Evening" || timeOfDay == "Night"))
        {
            turnOn.doAction();
        }
        // If no motion is detected for one minute, or if it is morning or day, turn the light off.
//        else if (time.Subtract(LastMotionTime) > TimeSpan.FromMinutes(1) || (timeOfDay == "Morning" || timeOfDay == "Noon"))
        else if (this.lastMotionTime.getMinute() - this.lastMotionTime.getMinute() > 1 || (timeOfDay == "Morning" || timeOfDay == "Noon"))
        {
            turnOff.doAction();
        }
    }
}
