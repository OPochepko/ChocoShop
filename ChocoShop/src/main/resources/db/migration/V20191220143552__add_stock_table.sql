create table stock
(
    id       int
        constraint stock_pk
            primary key
        constraint stock_chocolate_id_fk
            references chocolate,
    quantity int
);

