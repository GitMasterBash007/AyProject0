-- creating a schema for my first project
create schema Ay_project0;



-- creating a bank's customers table
create table bank_customers (
	fname varchar(50),
	lname varchar(50),
	email varchar(25) primary key,
	"password" varchar(25) not null,
    age int check (age >= 18)
);




-- creating a table for the acount informations for our customer
create table account_info (
	id serial primary key,
	account_type varchar(50),
	balance numeric not null,
    open_date varchar(15) not null,
    user_email varchar(25) not null unique
);





-- connecting both table though the forign key 
alter table account_info
add constraint fk_user_email
foreign key(user_email) references bank_customers(email);




-- adding a  few costumers to the bank_costumers table
insert into bank_customers values
('Charles', 'Jester', 'charles.jester@mail.com', 'superPassword1', 29);
insert into bank_customers values
('Ay', 'Sebirka', 'aysebirka@mail.com', 'ultimatPassword', 20),
('Mark', 'Cuban', 'crazymark@mail.com', 'superPasswording', 43);





-- to be able to drop our tables 

drop table if exists  bank_customers cascade;
drop table if exists  account_info cascade;


-- adding 
insert into account_info values
(default, 'checking', 100.00, '05-02-2022', 'charles.jester@mail.com'),
(default, 'checking', 1000000.00, '05-06-2022', 'aysebirka@mail.com'),
(default, 'savings', 1000.00, '05-02-2022', 'charles.jester@mail.com');


select * from bank_customers bc ;
select * from account_info ai ;

-- crating a virtual table
create view customer_account as
select bc.fname, bc.lname, ai.account_type, ai.balance, ai.open_date
from bank_customers bc
join account_info  ai ON bc.email = ai.user_email;


-- we are updating the account balance
update account set balance = 100000.00 where user_email = 'charles.jester@mail.com';

-- showing everything in the our virtual table
select * from customer_account ;
