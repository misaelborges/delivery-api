create table product (
	id bigint not null auto_increment,
	restaurant_id bigint not null,
	name varchar(80) not null,
	description text not null,
	price decimal(10,2) not null,
	active tinyint(1) not null,

	primary key (id),
	constraint fk_product_restaurante foreign key (restaurant_id) references restaurant (id)
) engine=InnoDB default charset=utf8;