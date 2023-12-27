package org.example.lab.spring.boot.datetime.timezone.persistent.data;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "dt")
public class DtJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "jpa_offsetdatetime_timestamp")
    private OffsetDateTime offsetDateTimeTimestamp;

    @CreationTimestamp
    @Column(name = "jpa_offsetdatetime_datetime")
    private OffsetDateTime offsetDateTimeDatetime;

    @CreationTimestamp
    @Column(name = "jpa_instant_timestamp")
    private Instant instantTimestamp;

    @CreationTimestamp
    @Column(name = "jpa_instant_datetime")
    private Instant instantDatetime;

    @SuppressWarnings("java:S2097")
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        DtJpaEntity dtEntity = (DtJpaEntity) o;
        return getId() != null && Objects.equals(getId(), dtEntity.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
