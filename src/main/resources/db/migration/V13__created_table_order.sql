create table orders (
  id bigint not null auto_increment,
  subtotal decimal(10,2) not null,
  shipping_fee decimal(10,2) not null,
  total_value decimal(10,2) not null,

  restaurant_id bigint not null,
  customer_user_id bigint not null,
  payment_method_id bigint not null,

  address_city_id bigint(20) not null,
  address_cep varchar(9) not null,
  address_street varchar(100) not null,
  address_number varchar(20) not null,
  address_complement varchar(60)  null,
  address_neighborhood varchar(60) not null,

  order_status varchar(10) not null,
  creation_date datetime not null,
  confirmation_date datetime  null,
  cancellation_date datetime  null,
  delivery_date datetime  null,

  primary key (id),

  constraint fk_order_restaurant foreign key (restaurant_id) references restaurant (id),
  constraint fk_order_customer_user foreign key (customer_user_id) references users (id),
  constraint fk_order_payment_method foreign key (payment_method_id) references payment_method (id)
) engine=InnoDB default charset=utf8;