package com.stana.utility;

import java.time.LocalDateTime;

public class TimeUtility {


    public static String getTimeOfDay_BadSmell()
    {
        LocalDateTime time = LocalDateTime.now();
        if (time.getHour() >= 0 && time.getHour() < 6)
        {
            return "Night";
        }
        if (time.getHour() >= 6 && time.getHour() < 12)
        {
            return "Morning";
        }
        if (time.getHour() >= 12 && time.getHour() < 18)
        {
            return "Afternoon";
        }
        return "Evening";
    }

    public static String getTimeOfDay_arg(LocalDateTime time)
    {
        if (time.getHour() >= 0 && time.getHour() < 6)
        {
            return "Night";
        }
        if (time.getHour() >= 6 && time.getHour() < 12)
        {
            return "Morning";
        }
        if (time.getHour() >= 12 && time.getHour() < 18)
        {
            return "Afternoon";
        }
        return "Evening";
    }
}
