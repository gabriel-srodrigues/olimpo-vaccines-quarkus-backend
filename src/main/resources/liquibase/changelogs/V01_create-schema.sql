--liquibase formatted sql

--changeset 20240904-1 author:gabriel.rodrigues@bonnasys.com.br label:create-schema

create table vaccines (
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    id         varchar(36) not null,
    name       varchar(255),
    producer   varchar(255),
    primary key (id));
