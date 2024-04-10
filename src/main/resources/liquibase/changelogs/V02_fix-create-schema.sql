--liquibase formatted sql

--changeset 20240904-2 author:gabriel.rodrigues@bonnasys.com.br label:create-schema

alter table if exists vaccines add column createdAt timestamp(6) with time zone;
alter table if exists vaccines add column updatedAt timestamp(6) with time zone;