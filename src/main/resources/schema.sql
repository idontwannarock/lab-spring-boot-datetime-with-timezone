DROP TABLE IF EXISTS dt;

CREATE TABLE IF NOT EXISTS dt
(
    id                            bigint auto_increment primary key,
    jpa_offsetdatetime_timestamp  timestamp(3)                       null,
    jpa_offsetdatetime_datetime   datetime(3)                        null,
    jpa_instant_timestamp         timestamp(3)                       null,
    jpa_instant_datetime          datetime(3)                        null,
    jdbc_offsetdatetime_timestamp timestamp(3)                       null,
    jdbc_offsetdatetime_datetime  datetime(3)                        null,
    jdbc_instant_timestamp        timestamp(3)                       null
);