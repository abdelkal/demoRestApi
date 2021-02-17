insert into user_app (id, username, password, is_active, roles, permissions) values (1, 'admin', 'password', 1, 'ADMIN', 'ACCESS_TEST1,ACCESS_TEST2');
insert into user_app (id, username, password, is_active, roles, permissions) values (2, 'user', 'password', 1, 'USER', '');
insert into user_app (id, username, password, is_active, roles, permissions) values (3, 'manager', 'password', 1, 'MANAGER', 'ACCESS_TEST1');

insert into customer (id, birth_date, first_name, last_name) values (1, sysdate(), "Kallouch", "Abdel");
insert into customer (id, birth_date, first_name, last_name) values (2, sysdate(), "Salmoun", "Myr");
insert into customer (id, birth_date, first_name, last_name) values (3, sysdate(), "Fatou", "Mata");
insert into customer (id, birth_date, first_name, last_name) values (4, sysdate(), "Gued", "Jihad");