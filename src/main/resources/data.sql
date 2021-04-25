insert into conduser (id, username, password, apartment, phone) values(1244, 'Gorin', '$2a$10$p/oNXY32XMaT4ErXUn1pcuVp7MNpO1vnYxtvsbbRYm0c22Lib90ny', 'bloco A, 101', '9999-9999');
insert into conduser (id, username, password, apartment, phone) values(1245, 'Cleo', '$2a$10$p/oNXY32XMaT4ErXUn1pcuVp7MNpO1vnYxtvsbbRYm0c22Lib90ny', 'bloco B, 202', '9999-8888');
insert into conduser (id, username,  password, apartment, phone) values(1246, 'Rose', '123456', 'bloco C, 303', '9999-7777');
COMMIT;

insert into CPost(id, date, details, title, user_id, category) values(400, '2021-04-23', 'Bolo de cenoura com cobertura de chocolate por R$30,00 entrego em casa.', 'Bolo de cenoura', 1244, 'venda');
insert into CPost(id, date, details, title, user_id, category) values(401, '2021-04-23','chinelo réi torado tamanho 38, interessados entrar em contato.','Chinelo',1245, 'venda');
COMMIT;

insert into Role (role) values('ROLE_ADMIN');
insert into Role (role) values('ROLE_USER');
COMMIT;

insert into users_roles (user_id, role_id) values(1244, 'ROLE_ADMIN');
insert into users_roles (user_id, role_id) values(1245, 'ROLE_USER');
COMMIT;