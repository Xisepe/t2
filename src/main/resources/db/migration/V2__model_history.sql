create table model_history(
    id serial primary key,
    model_id int references model(id),
    name varchar(128),
    create_date timestamp default current_timestamp
);