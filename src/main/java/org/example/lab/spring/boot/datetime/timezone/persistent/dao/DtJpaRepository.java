package org.example.lab.spring.boot.datetime.timezone.persistent.dao;

import org.example.lab.spring.boot.datetime.timezone.persistent.data.DtJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DtJpaRepository extends JpaRepository<DtJpaEntity, Long> {
}
