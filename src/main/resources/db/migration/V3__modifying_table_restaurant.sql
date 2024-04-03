ALTER TABLE restaurant ADD COLUMN cuisine_id BIGINT;

ALTER TABLE restaurant add constraint fk_restaurant_cuisine foreign key (cuisine_id) references cuisine (id);

