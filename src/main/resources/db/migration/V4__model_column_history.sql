create table model_column_history
(
    id           serial primary key,
    model_history_id int references model_history(id) on delete cascade,
    model_column_id int references model_column(id),
    model_id     int references model (id),
    display_name varchar(255),
    name         varchar(255),
    type         varchar(64),
    create_date timestamp default current_timestamp
);