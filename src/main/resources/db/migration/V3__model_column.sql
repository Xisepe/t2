create table model_column
(
    id           serial primary key,
    model_id     int references model (id) on delete cascade,
    display_name varchar(255) not null,
    name         varchar(255) not null,
    type         varchar(64)  not null
);
