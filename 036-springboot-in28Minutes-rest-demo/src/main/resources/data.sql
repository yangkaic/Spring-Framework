--create table user (
--id integer not null,
--birth_date timestamp,
--name varchar(255),
--primary key (id)
--)

--The sql file name should be data.sql by default

insert into user values(1001, sysdate(), 'AA');
insert into user values(1002, sysdate(), 'BB');
insert into user values(1003, sysdate(), 'CC');

insert into post values(2001, 'My First Post', 1001);
insert into post values(2002, 'My Secode Post', 1002);
insert into post values(2003, 'My Third Post', 1003);