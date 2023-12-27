package org.example.lab.spring.boot.datetime.timezone.persistent.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJdbcEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DtJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void update(Long id, OffsetDateTime nowWithOffset, Instant now) {
        jdbcTemplate.update("""
        UPDATE dt
        SET jdbc_offsetdatetime_timestamp = ?, jdbc_offsetdatetime_datetime = ?, jdbc_instant_timestamp = ?
        WHERE id = ?
        """, nowWithOffset, nowWithOffset, now, id);
    }

    public Optional<DtJdbcEntity> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("""
            SELECT
             id,
             jdbc_offsetdatetime_timestamp AS offsetDateTimeTimestamp,
             jdbc_offsetdatetime_datetime AS offsetDateTimeDatetime,
             jdbc_instant_timestamp AS instantTimestamp
             FROM dt WHERE id = ?
            """, getRowMapper(), id));
    }

    private RowMapper<DtJdbcEntity> getRowMapper() {
        if (log.isDebugEnabled()) {
            return (rs, rowNum) -> {
                Long resultId = rs.getLong("id");
                Timestamp offsetDateTimeTimestampAsTimestamp = rs.getTimestamp("offsetDateTimeTimestamp", Calendar.getInstance());
                Timestamp offsetDateTimeDatetimeAsTimestamp = rs.getTimestamp("offsetDateTimeDatetime", Calendar.getInstance());
                Timestamp instantTimestampAsTimestamp = rs.getTimestamp("instantTimestamp", Calendar.getInstance());
                log.debug("jdbc dt query result: [id={}, offsetDateTimeTimestamp={}, offsetDateTimeDatetime={}, instantTimestamp={}]", resultId, offsetDateTimeTimestampAsTimestamp, offsetDateTimeDatetimeAsTimestamp, instantTimestampAsTimestamp);

                ZoneId zoneId = ZoneId.systemDefault();
                var dt = new DtJdbcEntity();
                dt.setId(resultId);
                dt.setOffsetDateTimeTimestamp(ZonedDateTime.ofInstant(Instant.ofEpochMilli(offsetDateTimeTimestampAsTimestamp.getTime()), zoneId).toOffsetDateTime());
                dt.setOffsetDateTimeDatetime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(offsetDateTimeDatetimeAsTimestamp.getTime()), zoneId).toOffsetDateTime());
                dt.setInstantTimestamp(instantTimestampAsTimestamp.toInstant());
                return dt;
            };
        } else {
            return new BeanPropertyRowMapper<>(DtJdbcEntity.class);
        }
    }
}
