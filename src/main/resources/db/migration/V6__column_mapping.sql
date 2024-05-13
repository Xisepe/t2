create table column_mapping(
    id serial primary key,
    model_mapping_id int references model_mapping(id) on delete cascade,
    model_column_id int unique references model_column(id) on delete cascade,
    mapping_column_name varchar(255) not null,
    mapping_column_ordinal int not null
)