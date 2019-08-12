# if the database is already exist, please comment the next line.
create database samp_db;
use samp_db;
drop table if exists samp_db;
create table if not exists books (
# auto_increment id, identifier of a book
id int(10) unsigned not null auto_increment primary key,
# char(30), the name of a book
name char(30) not null,
# char(30), the ISBN of a book
isbn char(30) not null,
# char(10), use string to storage the price
price char(10) not null
);

