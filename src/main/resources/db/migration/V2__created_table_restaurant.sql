create table restaurant (
    id bigint not null auto_increment,
    cuisine_id bigint not null,
    name varchar(80) not null,
    delivery_fees decimal(10,2) not null,
    registration_date datetime not null,
    update_date datetime not null,
    primary key (id)
) engine=InnoDB;

alter table restaurant add constraint fk_restaurant_cuisine
foreign key (cuisine_id) references cuisine (id);