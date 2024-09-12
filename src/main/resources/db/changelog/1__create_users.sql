--liquibase formatted sql

--changeset artem.shegurov:1 endDelimiter:/

create table users
(
    id            number(19, 0) generated as identity primary key,
    is_deleted    char(1 char) default 'F' not null,
    login         varchar2(255 char)       not null
)
/