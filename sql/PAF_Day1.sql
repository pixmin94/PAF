/* 
create database test
*/

use paf_23;

/*

insert into customer (first_name, last_name) values ('Swee Kiat', 'Heng');
insert into customer (first_name, last_name) values ('Desmond', 'Koh');
insert into customer (first_name, last_name) values ('Chan Meng', 'Khong');
insert into customer (first_name, last_name) values ('Swee Kiat', 'Heng');
insert into customer (first_name, last_name) values ('Lawrence', 'Wong');
insert into customer (first_name, last_name) values ('Lawrence', 'Khong');
insert into customer (first_name, last_name) values ('Kee Teck', 'Wong');
insert into customer (first_name, last_name) values ('Lee Hsien', 'Loong');
insert into customer (first_name, last_name) values ('Derrick', 'Lee');
insert into customer (first_name, last_name) values ('Josephine', 'Teo');

-- 'single', 'standard', 'double', 'deluxe', 'prestige', 'president', 'suite'
insert into room (room_type, price) values ('single', 50);
insert into room (room_type, price) values ('standard', 100);
insert into room (room_type, price) values ('double', 150);
insert into room (room_type, price) values ('deluxe', 200);
insert into room (room_type, price) values ('prestige', 250);
insert into room (room_type, price) values ('president', 300);
insert into room (room_type, price) values ('suite', 350);

*/

alter table room    
modify column room_type enum('single', 'standard', 'double', 'deluxe', 'prestige', 'president', 'suite') not null;

insert into reservation (customer_id, room_id, start_date, end_date, total_cost)
values (1, 1, '2023-07-01', '2023-07-02', 100);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost)
values (2, 2, '2023-07-11', '2023-07-13', 300);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost)
values (3, 3, '2023-07-05', '2023-07-08', 450);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost)
values (4, 2, '2023-07-12', '2023-07-13', 300);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost)
values (5, 2, '2023-07-14', '2023-07-15', 300);


select * from customer;

select * from customer limit 5;

select id, first_name, last_name from customer limit 2;

select id, first_name, last_name from customer limit 2 offset 2;

select * from customer where last_name = 'Wong';

select * from customer where last_name like '%on%';

select * from reservation;

select * from reservation where start_date >= '2023-07-01' and start_date <= '2023-07-05';

-- use between instead of >= <=, it is inclusive
select * from reservation where start_date between '2023-07-01' and '2023-07-05';

select * from room;

select * from room where room_type in ('single', 'double', 'prestige');

