package com.stana.fake.model;

import com.stana.it.IDateTimeProvider;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FakeDateTimeProvider implements IDateTimeProvider {

    private LocalDateTime localDateTime;

    public FakeDateTimeProvider(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public LocalDateTime getDateTime() {
        return this.localDateTime;
    }
}
