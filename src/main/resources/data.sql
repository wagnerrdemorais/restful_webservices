insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Picollo');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Dante');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Beto');

insert into post(id, description, user_id)
values(20001, 'Hello', 10001);

insert into post(id, description, user_id)
values(20002, 'Olá', 10002);

insert into post(id, description, user_id)
values(20003, 'Hi', 10003);

insert into post(id, description, user_id)
values(20004, 'Hi Again', 10003);