create database if not exists burrito;

use burrito;

drop table if exists burrito_ingredients;
drop table if exists orders;
drop table if exists customers;
drop table if exists ingredients;

create table ingredients (
ingredients_pk int not null auto_increment,
meat varchar(7) not null,
rice varchar(10) not null,
beans varchar(7) not null,
primary key(ingredients_pk)
);

create table customers (
customer_pk int not null auto_increment,
first_name varchar (45) not null,
last_name varchar (45) not null,
phone varchar (20),
PRIMARY KEY (customer_pk)
);

create table orders (
order_pk int not null auto_increment,
customer_pk int not null,
primary key(order_pk),
foreign key(customer_pk) references customers(customer_pk)
);

create table burrito_ingredients (
order_pk int not null,
ingredients_pk int not null auto_increment,
foreign key(order_pk) references orders(order_pk),
foreign key(ingredients_pk) references ingredients(ingredients_pk)
);
