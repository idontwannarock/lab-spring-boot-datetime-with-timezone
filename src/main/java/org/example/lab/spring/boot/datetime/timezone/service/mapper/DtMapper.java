package org.example.lab.spring.boot.datetime.timezone.service.mapper;

import org.example.lab.spring.boot.datetime.timezone.controller.response.DtResponse;
import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJdbcEntity;
import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DtMapper {

    public DtResponse toRes(Long id, DtJpaEntity jpaEntity, DtJdbcEntity jdbcEntity) {
        var response = new DtResponse();
        response.setId(id);
        Optional.ofNullable(jpaEntity.getOffsetDateTimeTimestamp()).ifPresent(response::setJpaOffsetDateTimeTimestamp);
        Optional.ofNullable(jpaEntity.getOffsetDateTimeDatetime()).ifPresent(response::setJpaOffsetDateTimeDatetime);
        Optional.ofNullable(jpaEntity.getInstantTimestamp()).ifPresent(response::setJpaInstantTimestamp);
        Optional.ofNullable(jpaEntity.getInstantDatetime()).ifPresent(response::setJpaInstantDatetime);
        Optional.ofNullable(jdbcEntity.getOffsetDateTimeTimestamp()).ifPresent(response::setJdbcOffsetDateTimeTimestamp);
        Optional.ofNullable(jdbcEntity.getOffsetDateTimeDatetime()).ifPresent(response::setJdbcOffsetDateTimeDatetime);
        Optional.ofNullable(jdbcEntity.getInstantTimestamp()).ifPresent(response::setJdbcInstantTimestamp);
        return response;
    }
}
