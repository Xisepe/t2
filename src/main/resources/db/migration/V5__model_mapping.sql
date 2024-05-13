create table model_mapping
(
    id serial primary key,
    model_id int unique references model(id) on delete cascade,
    name varchar(128)
);
