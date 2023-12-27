package org.example.lab.spring.boot.datetime.timezone.persistent.data;

import lombok.Data;

import java.time.Instant;
import java.time.OffsetDateTime;

@Data
public class DtJdbcEntity {

    private Long id;
    private OffsetDateTime offsetDateTimeTimestamp;
    private OffsetDateTime offsetDateTimeDatetime;
    private Instant instantTimestamp;
}
