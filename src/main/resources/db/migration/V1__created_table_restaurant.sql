create table restaurant (
    id bigint not null auto_increment,
    name varchar(255) not null,
    delivery_fees decimal(38,2) not null,
    registration_date datetime not null,
    update_date datetime not null,
    primary key (id)
) engine=InnoDB;
