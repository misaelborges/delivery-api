create table city (
	id bigint not null auto_increment,
    state_id bigint not null,
    name varchar(50) not null,
    primary key (id)
) engine=InnoDB default charset=utf8;

alter table city add constraint fk_city_state foreign key (state_id) references state (id);