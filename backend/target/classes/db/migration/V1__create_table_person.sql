create table if not exists person
(
    id         bigint generated by default as identity
    constraint person_pkey
    primary key,
    address    varchar(100) not null,
    first_name varchar(80)  not null,
    last_name  varchar(255) not null,
    gender     varchar(6)   not null
    );

