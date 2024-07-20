create table grupo_permission (
	group_id bigint not null,
	permission_id bigint not null,

	primary key (group_id, permission_id)

) engine=InnoDB default charset=utf8;

alter table grupo_permission add constraint fk_grupo_permission_grupo
foreign key (group_id) references grupo(id);

alter table grupo_permission add constraint fk_grupo_permission_permission
foreign key (permission_id) references permission(id);