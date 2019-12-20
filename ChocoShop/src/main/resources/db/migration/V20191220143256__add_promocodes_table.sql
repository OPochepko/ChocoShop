create table promocodes
(
    id              serial      not null,
    code            varchar(30) not null,
    fixdiscount     int,
    percentdiscount int,
    _type           varchar     not null
);

create unique index promocodes_code_uindex
    on promocodes (code);

create unique index promocodes_id_uindex
    on promocodes (id);

alter table promocodes
    add constraint promocodes_pk
        primary key (id);

