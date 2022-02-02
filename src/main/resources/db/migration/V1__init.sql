create table students
(
    id         bigserial primary key,
    name       varchar(255),
    age        int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
insert into students (name, age)
values ('Bob', 18),
       ('Bill', 20),
       ('Mike', 18),
       ('Nick', 20),
       ('Ben', 18),
       ('John', 20),
       ('Jack', 21);
