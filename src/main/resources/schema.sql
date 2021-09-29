DROP TABLE IF EXISTS cities;


create table IF NOT EXISTS cities
(
    id         bigint       not null auto_increment primary key,
    name       varchar(255) null,
    region     varchar(255) null,
    district   varchar(255) null,
    population int          not null,
    foundation varchar(255) null
);