create table permission (
    id bigint not null auto_increment,
    description varchar(60),
    name varchar(100),
    primary key (id)
) engine=InnoDB default charset=utf8;