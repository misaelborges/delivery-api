ALTER TABLE deliveryapi.restaurant ADD COLUMN (
    address_city_id bigint, address_cep varchar(9),
	address_street varchar(100),
	address_number varchar(20),
	additional_address_details varchar(60),
	address_neighborhood varchar(60)
);