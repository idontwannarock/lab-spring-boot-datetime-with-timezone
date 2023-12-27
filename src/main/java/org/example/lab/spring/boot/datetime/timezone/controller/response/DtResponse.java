package org.example.lab.spring.boot.datetime.timezone.controller.response;

import lombok.Data;

import java.time.Instant;
import java.time.OffsetDateTime;

@Data
public class DtResponse {

    private Long id;
    private OffsetDateTime jpaOffsetDateTimeTimestamp;
    private OffsetDateTime jpaOffsetDateTimeDatetime;
    private Instant jpaInstantTimestamp;
    private Instant jpaInstantDatetime;
    private OffsetDateTime jdbcOffsetDateTimeTimestamp;
    private OffsetDateTime jdbcOffsetDateTimeDatetime;
    private Instant jdbcInstantTimestamp;
}
