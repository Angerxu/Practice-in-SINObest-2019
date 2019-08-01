#if the database is already exist, please comment the next line.
create database samp_db;
use samp_db;
create table books(
id int(10) unsigned not null auto_increment primary key,
name char(8) not null,
isbn char(12) not null,
price float not null
);

