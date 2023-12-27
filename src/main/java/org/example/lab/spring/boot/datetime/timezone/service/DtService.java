package org.example.lab.spring.boot.datetime.timezone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lab.spring.boot.datetime.timezone.controller.response.DtResponse;
import org.example.lab.spring.boot.datetime.timezone.persistent.dao.DtJdbcRepository;
import org.example.lab.spring.boot.datetime.timezone.persistent.dao.DtJpaRepository;
import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJdbcEntity;
import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJpaEntity;
import org.example.lab.spring.boot.datetime.timezone.service.mapper.DtMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DtService {

    private final DtJpaRepository jpaRepository;
    private final DtJdbcRepository jdbcRepository;

    private final DtMapper dtMapper;

    public Long create() {
        var dt = new DtJpaEntity();
        jpaRepository.save(dt);
        System.out.println();
        log.info("dt created: [id={}, offsetdatetime={}, instant={}]", dt.getId(), dt.getOffsetDateTimeDatetime(), dt.getInstantDatetime());
        System.out.println();
        jdbcRepository.update(dt.getId(), dt.getOffsetDateTimeDatetime(), dt.getInstantDatetime());
        return dt.getId();
    }

    public DtResponse findById(Long id) {
        DtJpaEntity jpaDt = jpaRepository.findById(id).orElse(new DtJpaEntity());
        System.out.println();
        log.info(jpaDt.toString());
        System.out.println();
        DtJdbcEntity jdbcDt = jdbcRepository.findById(id).orElse(new DtJdbcEntity());
        System.out.println();
        log.info(jdbcDt.toString());
        System.out.println();
        return dtMapper.toRes(id, jpaDt, jdbcDt);
    }
}
