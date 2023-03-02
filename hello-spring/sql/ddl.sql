use spring;
drop table if exists member;
CREATE TABLE member
(
    id bigint not null auto_increment,
    name varchar(45) not null,
    primary key(id)
);

