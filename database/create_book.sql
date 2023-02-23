create database bookdb;
use bookdb;

create table book(
id int(11) not null primary key,
title varchar(50) not null,
publisher varchar(30) not null,
author varchar(30) not null
);

insert into book (id, title, publisher, author) values
(0, 'Potter', 'Bloomsbury', 'J. K. Rowling'),
(1, 'HThe Lord of the Rings', 'Allen & Unwin', 'J. R. R. Tolkein'),
(2, 'Pride and Prejudice', 'T. Egerton Kingdom', 'Jane Austen');

commit;
