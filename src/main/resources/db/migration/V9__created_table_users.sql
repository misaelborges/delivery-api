create table users (
	id bigint not null auto_increment,
	name varchar(80) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	registration_date datetime not null,
	group_id bigint,

	primary key (id),
	constraint fk_users_grupo foreign key (group_id) references grupo (id)
) engine=InnoDB default charset=utf8;