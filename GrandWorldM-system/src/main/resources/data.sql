insert into sys_role(id,name) values(1,'ROLE_ADMIN');
insert into sys_role(id,name) values(2,'ROLE_USER');

insert into sys_user(id,name) values(1,'zs','zs');
insert into sys_user(id,name) values(2,'ls','ls');

insert into sys_user_role_list(sys_user_id,role_list_id) values(1,1);
insert into sys_user_role_list(sys_user_id,role_list_id) values(2,2);