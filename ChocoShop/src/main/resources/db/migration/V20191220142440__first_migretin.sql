create table chocolate
(
    id    serial      not null,
    name  varchar(50) not null,
    price int         not null
);

create unique index chocolate_id_uindex
    on chocolate (id);

create unique index chocolate_name_uindex
    on chocolate (name);

alter table chocolate
    add constraint chocolate_pk
        primary key (id);

