create table users
(
    id       serial not null,
    email    varchar(100),
    password varchar(100),
    role     varchar(10)
);

create unique index users_id_uindex
    on users (id);

alter table users
    add constraint users_pk
        primary key (id);
