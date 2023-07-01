use paf_jul2023;

create index idx_tvshows_name 
on tv_shows(title);

-- index not used in retrieving records
select * from tv_shows;

select * from tv_shows where title like '%Top%';

create index lang_release_date_idx
on tv_shows(release_date, lang);

select * from tv_shows
where release_date > '2023-06-05'
and lang like 'Eng%';


create table bank_account (
	id int not null auto_increment,
    full_name varchar(200),
    is_blocked boolean default false,
    is_active boolean default true,
    account_type varchar(20),
    balance numeric(7,2),
    constraint pk_bankaccount_id primary key (id)
);

