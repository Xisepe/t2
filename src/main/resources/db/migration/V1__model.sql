create table model(
    id serial primary key,
    name varchar(128) not null,
    description varchar(255)
);

create index idx_model_name on model(name);