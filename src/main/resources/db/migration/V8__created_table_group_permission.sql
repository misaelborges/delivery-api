create table group_permission (
	group_id bigint not null,
	permission_id bigint not null,

	primary key (group_id, permission_id)

) engine=InnoDB default charset=utf8;

alter table group_permission add constraint fk_group_permission_group
foreign key (group_id) references grupo(id);

alter table group_permission add constraint fk_group_permission_permission
foreign key (permission_id) references permission(id);